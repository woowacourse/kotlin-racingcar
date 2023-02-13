package racingcar

import racingcar.controller.GameController
import racingcar.domain.RaceManager
import racingcar.domain.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    GameController(RaceManager(RandomNumberGenerator()), InputView(), OutputView()).runGame()
}
