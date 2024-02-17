package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingCarGame
import racingcar.random.RacingCarRandomNumber
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(private val inputView: InputView, private val outputView: OutputView) {
    private lateinit var racingCarGame: RacingCarGame

    fun run() {
        val cars = createRacingCar()
        racingCarGame = RacingCarGame(cars, RacingCarRandomNumber)
        playGame()
    }

    private fun createRacingCar(): List<Car> = inputView.getCarNames().map { name -> Car(name) }

    private fun playGame() {
        val round = inputView.getRoundCount()
        outputView.printResultTitle()
        repeat(round) {
            val result = racingCarGame.race()
            outputView.printRoundResult(result)
        }
        getWinner()
    }

    private fun getWinner() {
        val winners = racingCarGame.findWinners()
        outputView.printWinners(winners)
    }
}
