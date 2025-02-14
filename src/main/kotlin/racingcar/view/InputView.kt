package racingcar.view

object InputView {
    fun inputCarNames(): List<String> {
        val input = readLine(INPUT_CAR_NAME_MESSAGE)
        val carNames = input.split(DELIMITER).filter { it.isNotBlank() }
        validateCarNames(carNames)

        return carNames
    }

    private fun validateCarNames(carNames: List<String>) {
        require(carNames.size > RACING_CAR_MIN_SIZE) { INVALID_CAR_SIZE_MESSAGE }
        require(carNames.size == carNames.distinct().size) { DUPLICATE_CAR_NAME_MESSAGE }
    }

    fun inputRacingCount(): Int {
        val input = readLine(INPUT_COUNT_MESSAGE)
        validateRacingCount(input)

        return input.toInt()
    }

    private fun validateRacingCount(racingCount: String) {
        require(racingCount.toIntOrNull()?.let { it > 0 } == true) { INVALID_COUNT_MESSAGE }
    }

    private fun readLine(message: String): String {
        println(message)
        return readlnOrNull() ?: ""
    }

    private const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val INPUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"

    private const val INVALID_CAR_SIZE_MESSAGE = "레이싱 게임은 두대 이상이어야 합니다."
    private const val DUPLICATE_CAR_NAME_MESSAGE = "자동차 이름이 중복됩니다."
    private const val INVALID_COUNT_MESSAGE = "시도할 횟수는 자연수여야 합니다."
    private const val DELIMITER = ","
    private const val RACING_CAR_MIN_SIZE = 1
}
