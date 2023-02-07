package racingcar.controller

import racingcar.service.RacingService
import racingcar.view.InputView

class RacingController(
    private val inputView: InputView,
    private val racingService: RacingService,
) {
    fun start() {
        val carNames = inputView.readCarNames()
        val roundCount = inputView.readRoundCount()
        val cars = carNames.map { carName ->
            racingService.createCar(carName)
        }

        repeat(roundCount) {
            cars.forEach { car ->
                racingService.moveRandomly(car)
            }
        }
    }
}
