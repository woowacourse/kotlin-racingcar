package calculator

private const val delimiter = " "

class Calculator {

    fun calculate(input: String): Int {
        val elements = input.split(delimiter)
            .groupBy { isNumber(it) }

        val numbers = elements[true]?.map { it.toInt() } ?: emptyList()
        val operators = elements[false] ?: emptyList()

        require(numbers.isNotEmpty() && operators.isNotEmpty()) { "[ERROR] 요구한 양식대로 입력해주세요" }
        return numbers.reduceIndexed { index, total, number ->
            calculate(total, number, operators[index - 1])
        }
    }

    private fun calculate(num1: Int, num2: Int, operator: String): Int {
        return Operator.of(operator).calculate(num1, num2)
    }

    private fun isNumber(element: String): Boolean = element.toIntOrNull() != null
}
