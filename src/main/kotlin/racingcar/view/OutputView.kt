package racingcar.view

import racingcar.constant.INPUT_CARS_NAME
import racingcar.constant.INPUT_MOVING_COUNT
import racingcar.constant.OUTPUT_RESULT
import racingcar.constant.OUTPUT_WINNER

class OutputView {
    fun printGettingCarsName() {
        println(INPUT_CARS_NAME)
    }

    fun printGettingMovingCount() {
        println(INPUT_MOVING_COUNT)
    }

    fun printResult() {
        println(OUTPUT_RESULT)
    }

    fun printWinner() {
        println(OUTPUT_WINNER)
    }
}
