package racingCar

import racingCar.controller.RaceGame
import racingCar.model.Referee
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val referee = Referee()
    val raceGame = RaceGame(inputView, outputView, referee)
    raceGame.run()
}
