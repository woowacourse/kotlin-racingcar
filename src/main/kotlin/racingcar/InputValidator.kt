package racingcar

import racingcar.domain.Car
import racingcar.domain.Messages

class InputValidator {
    fun carNamesValidate(input: String): List<Car> {
        emptyCheck(input)
        val names = input.split(",").map { it.trim() }
        duplicateNameCheck(names)

        names.forEach { name ->
            nameLengthCheck(name)
            availableNameCheck(name)
        }
        return toCars(names)
    }

    fun tryCountValidate(input: String): Int {
        emptyCheck(input)
        val number = positiveInputCheck(input)
        tryCountLengthCheck(number)
        return number
    }

    private fun emptyCheck(input: String) {
        require(input.isNotBlank()) { Messages.ERROR_EMPTY_INPUT.message }
    }

    private fun nameLengthCheck(name: String) {
        require(name.length in 1..5) { Messages.ERROR_NAME_LENGTH.message }
    }

    private fun duplicateNameCheck(names: List<String>) {
        require(names.size == names.distinct().size) { Messages.ERROR_DUPLICATE_NAME.message }
    }

    private fun availableNameCheck(name: String) {
        val regex = Regex("^[가-힣a-zA-Z0-9]*$")
        require(regex.matches(name)) { Messages.ERROR_NOT_AVAILABLE_NAME.message }
    }

    private fun positiveInputCheck(input: String): Int {
        val number =
            runCatching { input.toInt() }
                .getOrElse { throw IllegalArgumentException(Messages.ERROR_NOT_POSITIVE.message) }
        require(number > 0) { Messages.ERROR_NOT_POSITIVE.message }
        return number
    }

    private fun tryCountLengthCheck(number: Int) {
        require(number.toString().length < 9) { Messages.ERROR_OVERSIZE_TRY_COUNT.message }
    }

    private fun toCars(names: List<String>): List<Car> = names.map { Car(it) }
}
