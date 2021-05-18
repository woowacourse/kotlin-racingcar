package practice

import java.util.*
import java.util.regex.Pattern

class StringCalculator {
    private val pattern: Pattern = Pattern.compile("^[0-9+-/* ]*$")

    fun calculate(input: String): Int {
        validateInput(input)

        val elements = input.split(" ".toRegex()).toTypedArray()
        val expressionElements: Queue<String> = LinkedList(listOf(*elements))
        return calculateByQueue(expressionElements)
    }

    private fun validateInput(expression: String) {
        if (expression.isEmpty() || !pattern.matcher(expression).matches()) {
            throw IllegalArgumentException("올바르지 않은 입력값입니다.")
        }
    }

    private fun calculateByQueue(expressionElements: Queue<String>): Int {
        try {
            var result = expressionElements.poll()
                .toInt()
            while (expressionElements.isNotEmpty()) {
                val operator = expressionElements.poll()
                val nextValue = expressionElements.poll()
                    .toInt()
                // calculate
            }
            return result
        } catch (e: Exception) {
            throw IllegalArgumentException("잘못된 수식입니다.")
        }
    }
}