package racingcar

import racingcar.domain.Car
import racingcar.domain.Messages

class InputValidator {
    fun getValidatedCarNames(input: String): List<Car> {
        val names = input.split(",").map { it.trim() }
        duplicateNameCheck(names)
        return toCars(names)
    }

    fun getValidatedRaceCount(input: String): Int {
        emptyStringCheck(input)
        val number = positiveInputCheck(input)
        tryCountLengthCheck(number)
        return number
    }

    fun validCarNameChecker(name: String) {
        emptyStringCheck(name)
        carNameLengthCheck(name)
        carNameConsistPossibleCharactersCheck(name)
    }

    private fun emptyStringCheck(input: String) {
        require(input.isNotBlank()) { Messages.ERROR_EMPTY_INPUT.message }
    }

    private fun carNameConsistPossibleCharactersCheck(name: String) {
        val regex = Regex("^[가-힣a-zA-Z0-9]*$")
        require(regex.matches(name)) { Messages.ERROR_NOT_AVAILABLE_NAME.message }
    }

    private fun carNameLengthCheck(name: String) {
        require(name.length in 1..5) { Messages.ERROR_NAME_LENGTH.message }
    }

    fun possibleMoveValueCheck(value: Int) {
        require(value in 0..9) { Messages.ERROR_MOVE_VALUE }
    }

    private fun duplicateNameCheck(names: List<String>) {
        require(names.size == names.distinct().size) { Messages.ERROR_DUPLICATE_NAME.message }
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
