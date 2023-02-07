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
}
