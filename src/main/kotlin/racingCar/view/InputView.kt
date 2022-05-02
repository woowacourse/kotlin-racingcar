package racingCar.view

import racingCar.domain.Name

object InputView {

    private const val CAR_DELIMITER = ","

    val carNames: List<Name>
        get() {
            try {
                return splitCarNames(readln())
            } catch (e: IllegalArgumentException) {
                OutputView.printException(e.message)
                return carNames
            }
        }

    private tailrec fun splitCarNames(names: String): List<Name> {
        var splitNames = names.split(CAR_DELIMITER)
        try {
            return splitNames.map { Name(it) }
        } catch (e: IllegalArgumentException) {
            OutputView.printException(e.message)
            return carNames
        }
    }

    val numberOfGames: Int
        get() {
            return try {
                val value = toInt(readln())
                validateNumber(value)
                return value
            } catch (e: IllegalArgumentException) {
                OutputView.printException(e.message)
                return InputView.numberOfGames
            }
        }

    private fun toInt(number: String): Int {
        return number.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 시도할 횟수는 양수만 입력 가능합니다.")
    }

    private fun validateNumber(number: Int) {
        require(number > 0) { "[ERROR] 시도할 횟수는 양수만 입력 가능합니다." }
    }
}
