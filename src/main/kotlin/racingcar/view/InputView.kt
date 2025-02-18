package racingcar.view

class InputView {
    fun validateCarName(input: List<String>) {
        require(input.all { it.isNotEmpty() && it.length <= CONDITION_CAR_MAX_LENGTH }) {
            IllegalArgumentException(MESSAGE_INVALID_CAR_NAME)
        }
        require(input.size == input.toSet().size) {
            IllegalArgumentException(MESSAGE_DUPLICATE_CAR_NAME)
        }
    }

    fun validateCount(count: String): Int {
        require(count.toIntOrNull() != null) {
            IllegalArgumentException(MESSAGE_RACE_COUNT_NOT_INTEGER)
        }

        require(count.toInt() >= CONDITION_CAR_MIN_COUNT) {
            IllegalArgumentException(MESSAGE_RACE_COUNT_TOO_SMALL)
        }

        return count.toInt()
    }

    fun readCars(): List<String> {
        println(MESSAGE_INPUT_CAR_NAMES)
        val carsInput = readln().split(DELIMITER_CAR_INPUT).map { it.trim() }
        validateCarName(carsInput)
        return carsInput
    }

    fun readCount(): Int {
        println(MESSAGE_INPUT_RACE_COUNT)
        val count = readln()
        return validateCount(count)
    }

    companion object {
        private const val MESSAGE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val MESSAGE_INPUT_RACE_COUNT = "시도할 횟수는 몇 회인가요?"
        private const val MESSAGE_INVALID_CAR_NAME = "자동차 이름은 1글자 이상 5글자 이하여야 합니다."
        private const val MESSAGE_DUPLICATE_CAR_NAME = "자동차 이름에 중복이 있습니다."
        private const val MESSAGE_RACE_COUNT_NOT_INTEGER = "경주 횟수가 정수가 아닙니다."
        private const val MESSAGE_RACE_COUNT_TOO_SMALL = "경주 횟수가 1 이상이어야 합니다."

        private const val CONDITION_CAR_MAX_LENGTH = 5
        private const val CONDITION_CAR_MIN_COUNT = 1
        private const val DELIMITER_CAR_INPUT = ","
    }
}
