package racing.view

import racing.domain.generator.car.CarGenerator
import racing.domain.model.Car
import racing.domain.service.CarWinnersService
import racing.domain.service.RaceService

class Racing(private val inputView: InputView = InputView(), private val outputView: OutputView = OutputView()) {
    fun play() {
        val cars = getCars(inputView.readCarsName())
        val attempts = inputView.readAttempt()
        val raceService = RaceService(cars)
        race(raceService, attempts)
        outputView.printRaceWinner(CarWinnersService(cars).getWinners())
    }

    private fun getCars(carsName: List<String>): List<Car> {
        val cars = CarGenerator().createCars(carsName)
        return duplicateCarName(cars)
    }

    private fun duplicateCarName(cars: List<Car>): List<Car> {
        if (cars.size != cars.toSet().size) outputView.printRemoveDuplicateCars()
        return cars.distinct()
    }

    private fun race(
        raceService: RaceService,
        attemptCount: Int,
    ) {
        outputView.printResultTitle()
        repeat(attemptCount) {
            raceService.race()
            outputView.printCarState(raceService.cars)
        }
    }
}
