package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingCarGame
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    lateinit var racingCarGame: RacingCarGame

    fun run() {
        val carNames = inputView.getCarNames()
        val cars = carNames.map { name ->
            Car(name)
        }
        val round = inputView.getRoundCount()
        startRound(cars, round)


    }

    fun startRound(cars: List<Car>, round: Int) {
        racingCarGame = RacingCarGame(cars)
        outputView.printResultTitle()
        repeat(round) {
            val result = racingCarGame.race()
            outputView.printRoundResult(result)
        }
    }
}