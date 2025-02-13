package racingcar.view

import racingcar.utils.Constants.INPUT_CARNAMES_MESSAGE
import racingcar.utils.Constants.INPUT_TRYCOUNT_MESSAGE

class InputView {
    fun insertCarNames(): String {
        println(INPUT_CARNAMES_MESSAGE)
        return readln()
    }

    fun insertTryCount(): String {
        println(INPUT_TRYCOUNT_MESSAGE)
        return readln()
    }
}
