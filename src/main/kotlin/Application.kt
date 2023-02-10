package racingcar

import racingcar.controller.GameController
import racingcar.domain.RaceManager
import racingcar.domain.RandomNumberGenerator

fun main() {
    GameController(RaceManager(RandomNumberGenerator())).runGame()
}
