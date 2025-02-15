class Racing {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun play() {
        val cars = getCars(inputView.readCarsName())
        val attempts = inputView.readAttempt()
        race(cars, attempts)
        val winners = getWinners(cars)
        outputView.printRaceWinner(winners)
    }

    private fun getCars(carsName: List<String>): List<Car> {
        val cars = CarFactory().createCar(carsName)
        return duplicateCarName(cars)
    }

    private fun duplicateCarName(cars: List<Car>): List<Car> {
        if (cars.size != cars.toSet().size) outputView.printDuplicate()
        return cars.distinct()
    }

    private fun race(
        cars: List<Car>,
        attempts: Int,
    ) {
        outputView.printResultTitle()
        repeat(attempts) {
            carMove(cars)
        }
    }

    private fun carMove(carsName: List<Car>) {
        carsName.forEach { car ->
            car.move(TryMoveNumberGenerator())
        }
        outputView.printCarState(carsName)
    }

    private fun getWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == maxPosition }
    }
}
