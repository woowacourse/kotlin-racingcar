package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingCarGame
import racingcar.view.InputView

class RacingCarController(private val inputView: InputView) {

    fun run() {
        val carNames = inputView.getCarNames()
        val cars = carNames.map { name ->
            Car(name)
        }
        val round = inputView.getRoundCount()
        val game = RacingCarGame(cars, round)

        val result = game.race()
    }
}