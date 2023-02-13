package racingcar.domain.validator

import java.util.regex.Pattern

object NumberValidator {
    fun isNumber(value: String): Boolean = Pattern.matches("^[0-9]+$", value)
}
