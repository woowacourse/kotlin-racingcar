package practice

import java.lang.IllegalArgumentException
import java.util.regex.Pattern

class StringCalculator {
    private val pattern: Pattern = Pattern.compile("^[0-9+-/* ]*$")

    fun calculate(input: String): Int  {
        val expression = input.trim()
        validateInput(expression)
        return 0
    }

    private fun validateInput(expression: String) {
        if (expression.isEmpty() || !pattern.matcher(expression).matches()) {
            throw IllegalArgumentException("올바르지 않은 입력값입니다.")
        }
    }
}