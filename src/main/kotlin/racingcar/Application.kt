package racingcar

import racingcar.domain.RacingGame
import racingcar.domain.numbergenerator.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    RacingGame(InputView(), OutputView(), RandomNumberGenerator()).runGame()
}
