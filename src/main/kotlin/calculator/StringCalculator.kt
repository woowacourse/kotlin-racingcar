package calculator

object StringCalculator {

    fun calculate(input: String): Int {
        val inputSplit = input.split(" ")
        var result = inputSplit[0].toInt()
        for (index in (1 until inputSplit.size) step 2) {
            val operator = inputSplit[index]
            val second = inputSplit[index + 1].toInt()
            result = operate(result, second, operator)
        }
        return result
    }

    private fun operate(first: Int, second: Int, operator: String): Int {
        return OPERATORS.getOrElse(operator) { throw IllegalArgumentException("연산이 없습니다.") }(first, second)
    }

    private val OPERATORS =
        mapOf(
            "+" to { first: Int, second: Int -> first + second },
            "-" to { first: Int, second: Int -> first - second },
            "*" to { first: Int, second: Int -> first * second },
            "/" to { first: Int, second: Int ->
                require(second != 0) { "0으로 나눌 수 없습니다." }
                first / second
            }
        )
}
