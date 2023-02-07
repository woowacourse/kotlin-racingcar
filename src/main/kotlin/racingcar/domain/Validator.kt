package racingcar.domain

import racingcar.constant.MAX_NAME_LENGTH

object Validator {
    fun isNameLengthInRange(value: String): Boolean {
        val length = value.length
        if (length <= 0 || length > MAX_NAME_LENGTH) {
            return false
        }
        return true
    }
}
