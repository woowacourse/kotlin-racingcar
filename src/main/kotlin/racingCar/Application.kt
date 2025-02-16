package racingCar

import racingCar.controller.RaceGame
import racingCar.model.RaceRule
import racingCar.model.RandomGenerator
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val randomGenerator = RandomGenerator()
    val raceRule = RaceRule()
    val raceGame = RaceGame(inputView, outputView, randomGenerator, raceRule)
    raceGame.run()
}
