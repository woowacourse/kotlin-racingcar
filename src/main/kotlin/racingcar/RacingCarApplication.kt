package racingcar

import racingcar.constants.Constants.MOVE_THRESHOLD
import racingcar.controller.RacingController
import racingcar.model.MoveManagerWithMinNum
import racingcar.model.RandomNumberGenerator

fun main() {
    val moveManager = MoveManagerWithMinNum(MOVE_THRESHOLD)
    val numberGenerator = RandomNumberGenerator()
    val racingController = RacingController(moveManager, numberGenerator)
    racingController.start()
}
