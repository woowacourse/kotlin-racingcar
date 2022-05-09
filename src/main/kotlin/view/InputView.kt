package view

object InputView {
    private const val CAR_DELIMITER = ","

    val carNames: List<String>
        get() {
            return try {
                val line = readln()
                splitCarNames(line)
            } catch (e: IllegalArgumentException) {
                OutputView.printException(e.message)
                carNames
            }
        }

    private fun splitCarNames(readLine: String): List<String> {
        val carNames = readLine.split(CAR_DELIMITER)
        try {
            validateDuplication(carNames)
        } catch (e: IllegalArgumentException) {
            OutputView.printException(e.message)
            return InputView.carNames
        }
        return carNames
    }

    val numberOfGames: Int
        get() {
            return try {
                val line = readln()
                validateEmptyString(line)
                line.toIntOrNull() ?: throw IllegalArgumentException("시도할 횟수는 양수만 입력 가능합니다.")
            } catch (e: IllegalArgumentException) {
                OutputView.printException(e.message)
                InputView.numberOfGames
            }
        }

    private fun validateEmptyString(line: String) {
        require(line.isNotEmpty()) { "빈 문자열을 입력하면 안됩니다." }
    }

    private fun validateDuplication(carNames: List<String>) {
        val isDuplicated = carNames
            .distinct()
            .count() != carNames.size
        require(!isDuplicated) { "자동차 이름은 중복이 되면 안됩니다." }
    }
}
