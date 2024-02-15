package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingCarGame
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    private lateinit var racingCarGame: RacingCarGame

    fun run() {
        val cars = createRacingCar()
        val round = inputView.getRoundCount()
        racingCarGame = RacingCarGame(cars)
        startRound(round)
        getWinner()
    }

    private fun createRacingCar(): List<Car> = inputView.getCarNames().map { name -> Car(name) }

    private fun startRound(round: Int) {
        outputView.printResultTitle()
        repeat(round) {
            val result = racingCarGame.race()
            outputView.printRoundResult(result)
        }
    }

    private fun getWinner() {
        val winners = racingCarGame.findWinners()
        outputView.printWinners(winners)
    }
}
