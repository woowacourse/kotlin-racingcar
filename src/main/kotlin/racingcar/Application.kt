package racingcar

import racingcar.controller.RacingController
import racingcar.model.RacingGame
import racingcar.model.RandomNumberGenerator

fun main() {
    val randomNumber = RandomNumberGenerator()
    val racingGame = RacingGame(randomNumber)

    RacingController(racingGame).run()
}
