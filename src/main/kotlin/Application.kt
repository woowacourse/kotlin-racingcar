package racingcar

import racingcar.controller.GameController
import racingcar.domain.RaceManager
import racingcar.racingcar.domain.numbergenerator.RandomNumberGenerator

fun main() {
    GameController(RaceManager(RandomNumberGenerator())).runGame()
}
