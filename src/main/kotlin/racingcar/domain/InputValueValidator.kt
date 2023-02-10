package racingcar.domain

import racingcar.constant.MAX_NAME_LENGTH
import java.util.regex.Pattern

object InputValueValidator {
    fun isNameLengthInRange(value: String): Boolean {
        val length = value.length
        return !(length <= 0 || length > MAX_NAME_LENGTH)
    }

    fun isNumber(value: String): Boolean = Pattern.matches("^[0-9]+$", value)
}
