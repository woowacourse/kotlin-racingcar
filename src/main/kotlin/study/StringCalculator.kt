package study

object StringCalculator {

    private val OPERATORS = mapOf(
        "+" to { left: Int, right: Int -> left + right },
        "-" to { left: Int, right: Int -> left - right },
        "*" to { left: Int, right: Int -> left * right },
        "/" to { left: Int, right: Int ->
            require(right != 0) { "0으로 나눌 수 없습니다." }
            left / right
        }
    )

    fun calculate(string: String): Int {
        val stringSplit = string.split(" ")

        var left = parseInt(stringSplit[0])
        for (idx in (1 until stringSplit.size) step 2) {
            val operator = stringSplit[idx]
            val right = parseInt(stringSplit[idx + 1])
            left = operate(left, right, operator)
        }

        return left
    }

    private fun operate(left: Int, right: Int, operator: String): Int {
        return OPERATORS.getOrElse(operator) { throw IllegalArgumentException("해당하는 연산자가 없습니다.") }(left, right)
    }

    private fun parseInt(string: String): Int {
        return string.toIntOrNull() ?: throw IllegalArgumentException("숫자로 변환할 수 없습니다.")
    }
}
