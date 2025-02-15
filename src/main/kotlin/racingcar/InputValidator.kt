package racingcar

import racingcar.domain.Car
import racingcar.domain.Messages

class InputValidator {
    fun validRaceCountChecker(input: String) {
        emptyStringCheck(input)
        positiveInputCheck(input)
        tryCountLengthCheck(input)
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

    fun duplicateCarNameCheck(cars: List<Car>) {
        require(cars.map { it.name }.distinct().size == cars.size) { Messages.ERROR_DUPLICATE_NAME.message }
    }

    private fun positiveInputCheck(input: String) {
        val number =
            runCatching { input.toInt() }
                .getOrElse { throw IllegalArgumentException(Messages.ERROR_NOT_POSITIVE.message) }
        require(number > 0) { Messages.ERROR_NOT_POSITIVE.message }
    }

    private fun tryCountLengthCheck(input: String) {
        require(input.length < 9) { Messages.ERROR_OVERSIZE_TRY_COUNT.message }
    }
}
