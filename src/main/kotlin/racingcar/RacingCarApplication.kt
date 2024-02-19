package racingcar

import racingcar.constants.Constants.MAXIMUM_RANDOM_SELECTION_NUM
import racingcar.constants.Constants.MINIMUM_RANDOM_SELECTION_NUM
import racingcar.constants.Constants.MOVE_THRESHOLD
import racingcar.controller.RacingController
import racingcar.model.MoveManagerWithMinNum
import racingcar.model.RandomNumberGenerator

fun main() {
    val moveManager = MoveManagerWithMinNum(MOVE_THRESHOLD)
    val numberGenerator = RandomNumberGenerator(
        MINIMUM_RANDOM_SELECTION_NUM,
        MAXIMUM_RANDOM_SELECTION_NUM
    )
    val racingController = RacingController(moveManager, numberGenerator)
    racingController.start()
}
