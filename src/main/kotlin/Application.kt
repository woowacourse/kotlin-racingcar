package racingcar

import racingcar.controller.GameController
import racingcar.domain.RaceManager
import racingcar.domain.RandomNumberGenerator
import racingcar.view.InputView

fun main() {
    val input by lazy { InputView() }
    GameController(RaceManager(RandomNumberGenerator(), input.inputCarNames(), input.inputRacingCount())).runGame()
}
