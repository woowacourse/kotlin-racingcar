package calculator

class StringCalculator {

    fun add(input: String?): Int {
        if (input === null || input.isEmpty()) {
            return 0
        }
        val regex = Regex("//(.)\n(.*)")
        val matchResult = regex.matchEntire(input)
        if (matchResult != null) {
            return calcSumWithCustomDelimiter(matchResult)
        }
        return calcSumNoCustomDelimiter(input)
    }

    private fun calcSumWithCustomDelimiter(matchResult: MatchResult): Int {
        val groupValues = matchResult.groupValues
        val customDelimiter = groupValues[1]
        val tokens = groupValues[2].split(customDelimiter)
        return calcSum(tokens)
    }

    private fun calcSumNoCustomDelimiter(input: String): Int {
        val split = input.split(",", ":")
        if (split.size == 1) {
            return input.toInt()
        }

        return calcSum(split)
    }

    private fun calcSum(strings: List<String>): Int {
        var sum = 0
        for (number in strings) {
            validatePositive(number.toInt())
            sum += number.toInt()
        }
        return sum
    }

    private fun validatePositive(number: Int) {
        if (number < 0) {
            throw IllegalArgumentException("음수를 입력하면 안됩니다.")
        }
    }
}
