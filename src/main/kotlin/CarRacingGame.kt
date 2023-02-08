class CarRacingGame(
    private val referee: Referee = Referee(),
    private val carGenerator: CarGenerator = CarGenerator(),
    private val carRacingGamePlayerGenerator: CarRacingGamePlayerGenerator = CarRacingGamePlayerGenerator()
) {

    fun play() {
        val players = initPlayers()
        val result = startDriving(players)
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

    private fun initPlayers(): List<CarRacingGamePlayer> {
        val cars = initCars()
        val numberOfTry = initNumberOfTry()

        return carRacingGamePlayerGenerator.generateCarRacers(cars, numberOfTry)
    }

    private fun startDriving(players: List<CarRacingGamePlayer>): List<CarPath> {
        val carPath = mutableListOf<CarPath>()

        players.forEach { player ->
            carPath.add(player.moveCar())
        }

        return carPath.toList()
    }

    private fun showWinner(cars: List<Car>) {
        OutputView.printWinner(referee.decideWinner(cars))
    }

    private fun showResult(cars: List<Car>) {
        OutputView.printResult(cars)
    }
}
