class Racing {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun play() {
        val cars = getCars(inputView.readCarsName())
        val attempts = inputView.readAttempt()
        val carService = CarService(cars)
        race(carService, attempts)
        outputView.printRaceWinner(carService.getWinners())
    }

    private fun getCars(carsName: List<String>): List<Car> {
        val cars = CarFactory().createCars(carsName)
        return duplicateCarName(cars)
    }

    private fun duplicateCarName(cars: List<Car>): List<Car> {
        if (cars.size != cars.toSet().size) outputView.printRemoveDuplicateCars()
        return cars.distinct()
    }

    private fun race(
        carService: CarService,
        attemptCount: Int,
    ) {
        outputView.printResultTitle()
        repeat(attemptCount) {
            carService.race()
            outputView.printCarState(carService.cars)
        }
    }
}
