package racingcar.domain.validator

import java.util.regex.Pattern

object NumberValidator {
    fun String.isNumber(): Boolean = Pattern.matches("^[0-9]+$", this)
}
