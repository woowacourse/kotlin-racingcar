package calculator

class StringCalculator {

    fun calculate(input: String): Int {
        if (input.isEmpty()) {
            throw IllegalArgumentException("잘못된 입력값 형식입니다.")
        }
        val splitedInput = input.split(" ")
        var result = splitedInput[0].toInt()
        for (i in (1 until splitedInput.size) step 2) {
            val operator = splitedInput[i]
            val operand = splitedInput[i + 1].toInt()
            result = operate(operator, result, operand)
        }
        return result
    }

    private fun operate(operator: String, operand1: Int, operand2: Int): Int {
        if (operator == "+") {
            return operand1 + operand2
        }
        if (operator == ("-")) {
            return operand1 - operand2
        }
        if (operator == ("*")) {
            return operand1 * operand2
        }
        if (operator == ("/")) {
            return operand1 / operand2
        }
        throw IllegalArgumentException()
    }
}
