package racingcar.ui.controller

import racingcar.domain.generator.car.CarGenerator
import racingcar.domain.model.Car
import racingcar.domain.service.CarWinnersService
import racingcar.domain.service.RaceService
import racingcar.ui.view.InputView
import racingcar.ui.view.OutputView

class RacingController(private val inputView: InputView = InputView(), private val outputView: OutputView = OutputView()) {
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
