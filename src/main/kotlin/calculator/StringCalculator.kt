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
                .map { it.toInt() }
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
    }

    private fun validatePositive(numbers: List<Int>) {
        numbers.stream()
            .filter { it < 0 }
            .findAny()
            .ifPresent { throw IllegalArgumentException("[ERROR] 숫자는 양수여야 합니다.") }
    }
}
