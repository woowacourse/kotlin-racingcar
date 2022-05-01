package view

object InputView {

    private const val MIN_NAME_LENGTH = 1
    private const val MAX_NAME_LENGTH = 5
    private const val CAR_DELIMITER = ","
    private const val NUMBER_REGEX = "^[0-9]+$"

    val carNames: List<String>
        get() {
            var line = ""
            try {
                line = readLine().toString()
                validateEmptyString(line)
            } catch (e: IllegalArgumentException) {
                OutputView.printException(e.message)
                return carNames
            }
            return splitCarNames(line)
        }

    private fun splitCarNames(readLine: String): List<String> {
        val carNames = readLine.split(CAR_DELIMITER)
        try {
            validateNameSize(carNames)
            validateDuplication(carNames)
        } catch (e: IllegalArgumentException) {
            OutputView.printException(e.message)
            return InputView.carNames
        }
        return carNames
    }

    val numberOfGames: Int
        get() {
            val numberOfGames = try {
                val line = readLine().toString()
                validateEmptyString(line)
                toInt(line)
            } catch (e: IllegalArgumentException) {
                OutputView.printException(e.message)
                return InputView.numberOfGames
            }
            return numberOfGames
        }

    private fun validateEmptyString(line: String) {
        require(line.isNotEmpty()) { "빈 문자열을 입력하면 안됩니다." }
    }

    private fun validateNameSize(carNames: List<String>) {
        carNames.forEach { carName: String ->
            require(carName.length >= MIN_NAME_LENGTH && carName.length <= MAX_NAME_LENGTH)
            { "자동차 이름의 길이는 한 글자 이상, 다섯 글자 이하여야합니다." }
        }
    }

    private fun validateDuplication(carNames: List<String>) {
        val isDuplicated = carNames.stream()
            .distinct()
            .count() == carNames.size.toLong()

        require(isDuplicated) { "자동차 이름은 중복이 되면 안됩니다." }
    }

    private fun toInt(line: String): Int {
        validateNumber(line)
        return line.toInt()
    }

    private fun validateNumber(number: String) {
        require(number.matches(Regex(NUMBER_REGEX)) && number.toInt() > 0) { "시도할 횟수는 양수만 입력 가능합니다." }
    }
}
