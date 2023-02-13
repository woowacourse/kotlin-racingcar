package racingcar.domain.validator

import racingcar.constant.MAX_NAME_LENGTH

object InputValidator {
    fun isNameLengthInRange(value: String): Boolean {
        val length = value.length
        return !(length <= 0 || length > MAX_NAME_LENGTH)
    }
}

