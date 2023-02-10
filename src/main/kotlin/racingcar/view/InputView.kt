package racingcar.view

import racingcar.resources.INPUT_CAR_NAMES
import racingcar.resources.INPUT_COUNT

class InputView {
    fun inputCarNames(): List<String> {
        println(INPUT_CAR_NAMES)
        return readlnOrNull()?.split(',') ?: List(0) { "" }
    }

    fun inputRacingCount(): Int {
        println(INPUT_COUNT)
        return readlnOrNull()?.toIntOrNull() ?: 0
    }
}
