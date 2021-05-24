package calculator

class StringCalculator {
    fun calculate(input: String): Int {
        require(!input.isNullOrBlank())
        val elements = splitInput(input)
        var result = getNumber(elements[0])
        for (opIndex in 1 until elements.size step 2) {
            var num2 = getNumber(elements[opIndex + 1])
            result = Operator.of(elements[opIndex]).calculate(result, num2)
        }
        return result
    }

    private fun getNumber(num: String): Int {
        return num.toIntOrNull() ?: throw IllegalArgumentException("피연산자가 숫자가 아닙니다.")
    }

    private fun splitInput(input: String): List<String> {
        val split = input.split(" ")
        if (split.isEmpty()) throw IllegalArgumentException("입력값이 없습니다.")
        return split
    }
}
