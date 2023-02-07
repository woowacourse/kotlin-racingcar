package racingcar.utils

class Validator {

    fun checkCarNames(input: String): List<String> {
        val names = input.split(",").toMutableList()

        for (i in names.indices) {
            names[i] = names[i].trim()

            if (names[i].length !in 1..4) {
                throw IllegalArgumentException("error")
            }
        }

        if (names.toSet().size != names.size) {
            throw IllegalArgumentException("error")
        }

        return names
    }

    fun checkRoundCount(input: String): Int {
        val roundCount = input.toIntOrNull() ?: throw IllegalArgumentException("error")

        if (roundCount <= 0) {
            throw IllegalArgumentException("0보다 작습니다.")
        }
        if (roundCount > Int.MAX_VALUE) {
            throw IllegalArgumentException("너무 숫자가 큼 ㅜㅜ")
        }

        return roundCount
    }
}
