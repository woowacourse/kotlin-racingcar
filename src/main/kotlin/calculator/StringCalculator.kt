package calculator

class StringCalculator(val numbers: List<Int>) {

    init {
        validatePositive(numbers)
    }

    companion object {
        fun split(input: String): StringCalculator {
            val numbers = splitCustom(input).map { toInt(it) }
            return StringCalculator(numbers)
        }

        private fun splitCustom(input: String): List<String> {
            val splitInput = input.split("\n")
            val splitDelimiter = splitInput[0]
            if (splitDelimiter.startsWith("//")) {
                return splitInput[1].split(splitDelimiter.substring(2, 3))
            }
            return input.split(",", ":")
        }

        private fun toInt(number: String): Int =
            number.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자를 입력하세요")
    }

    private fun validatePositive(numbers: List<Int>) {
        require(numbers.none { it < 0 }) { "[ERROR] 숫자는 양수여야 합니다." }
    }

    fun sum(): Int = numbers.sum()
}
