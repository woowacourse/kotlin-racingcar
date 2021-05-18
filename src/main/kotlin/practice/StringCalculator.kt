package practice

import java.util.*
import java.util.function.IntBinaryOperator
import java.util.regex.Pattern
import kotlin.IllegalArgumentException as IllegalArgumentException1

object StringCalculator {
    private val pattern: Pattern = Pattern.compile("^[0-9+-/* ]*$")

    fun calculate(input: String): Int {
        validateInput(input.trim())

        val elements = input.split(" ".toRegex()).toTypedArray()
        val expressionElements: Queue<String> = LinkedList(listOf(*elements))
        return validateExpressionAndCalculate(expressionElements)
    }

    private fun validateInput(expression: String) {
        if (expression.isEmpty() || !pattern.matcher(expression).matches()) {
            throw IllegalArgumentException1("올바르지 않은 입력값입니다.")
        }
    }

    private fun validateExpressionAndCalculate(expressionElements: Queue<String>): Int {
        try {
            return calculateBySequence(expressionElements)
        } catch (e: Exception) {
            throw IllegalArgumentException1("잘못된 수식입니다.")
        }
    }

    private fun calculateBySequence(expressionElements: Queue<String>): Int {
        var result = expressionElements.poll()
            .toInt()
        while (expressionElements.isNotEmpty()) {
            val operator = expressionElements.poll()
            val nextValue = expressionElements.poll()
                .toInt()
            result = Operator.calculate(result, nextValue, operator).orElseThrow()
        }
        return result
    }
}

enum class Operator(
    private val signature: String,
    private val function: IntBinaryOperator
) {
    PLUS("+", IntBinaryOperator { a: Int, b: Int -> a + b }),
    MINUS("-", IntBinaryOperator { a: Int, b: Int -> a - b }),
    TIMES("*", IntBinaryOperator { a: Int, b: Int -> a * b }),
    DIVIDE("/", IntBinaryOperator { a: Int, b: Int -> a / b });

    companion object {
        fun calculate(a: Int, b: Int, operator: String): Optional<Int> {
            return Arrays.stream(values())
                .filter { calc: Operator -> calc.signature == operator }
                .map { calc: Operator -> calc.function.applyAsInt(a, b) }
                .findFirst()
        }
    }
}