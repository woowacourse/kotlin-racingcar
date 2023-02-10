package racingcar

import racingcar.controller.GameController
import racingcar.domain.RacingManager
import racingcar.domain.RandomNumberGenerator

fun main() {
    GameController(RacingManager(RandomNumberGenerator())).runGame()
}
