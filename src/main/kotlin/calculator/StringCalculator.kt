package calculator

import java.util.stream.Collectors

class StringCalculator(val numbers: List<Int>) {

    init {
        validatePositive(numbers)
    }

    companion object {
        fun split(input: String): StringCalculator {
            val numbers = splitCustom(input)
                .stream()
                .map { toInt(it) }
                .collect(Collectors.toList())
                .toList()
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

        private fun toInt(number: String): Int {
            try {
                return number.toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("[ERROR] 숫자를 입력하세요")
            }
        }
    }

    private fun validatePositive(numbers: List<Int>) {
        numbers.stream()
            .filter { it < 0 }
            .findAny()
            .ifPresent { throw IllegalArgumentException("[ERROR] 숫자는 양수여야 합니다.") }
    }

    fun sum(): Int = numbers.sum()
}
