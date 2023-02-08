class CarRacingGame(
    private val referee: Referee = Referee(),
    private val carGenerator: CarGenerator = CarGenerator(),
    private val carRacingGamePlayerGenerator: CarRacingGamePlayerGenerator = CarRacingGamePlayerGenerator()
) {

    fun play() {
        val cars = initCars()
        val numberOfTry = initNumberOfTry()
        val players = initPlayers(cars, numberOfTry)
        val carsPath = startDriving(players)
        showPath(carsPath, numberOfTry)
        showWinner(cars)
    }

    private fun initCars(): List<Car> {
        val names = InputView.inputCarNames().split(',')

        return carGenerator.generateCars(names)
    }

    private fun initNumberOfTry(): Int {
        val numberOfTry = InputView.inputNumberOfTry()

        InputValidator.validateIsNumeric(numberOfTry)

        return numberOfTry.toInt()
    }

    private fun initPlayers(cars: List<Car>, numberOfTry: Int): List<CarRacingGamePlayer> {

        return carRacingGamePlayerGenerator.generateCarRacers(cars, numberOfTry)
    }

    private fun startDriving(players: List<CarRacingGamePlayer>): List<CarPath> {
        val carsPath = mutableListOf<CarPath>()

        players.forEach { player ->
            carsPath.add(player.moveCar())
        }

        return carsPath.toList()
    }

    private fun showWinner(cars: List<Car>) {
        OutputView.printWinner(referee.decideWinner(cars))
    }

    private fun showPath(carsPath: List<CarPath>, numberOfTry: Int) {
        repeat(numberOfTry) { number ->
            OutputView.printResult(carsPath, number)
        }
    }
}
