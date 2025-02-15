import java.util.Scanner

class InputView {
    private val scanner = Scanner(System.`in`)

    fun readCarsName(): List<String> {
        println(INPUT_CAR_NAME)
        return scanner.nextLine().split(CAR_DELIMITER)
    }

    fun readAttempt(): Int {
        println(INPUT_ATTEMPTS)
        return requireNotNull(scanner.nextLine().toIntOrNull()) { ATTEMPT_INPUT_ERROR }
    }

    companion object {
        private const val INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val INPUT_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
        private const val ATTEMPT_INPUT_ERROR = "[ERROR]: 시도 횟수를 입력해주세요."
        private const val CAR_DELIMITER = ","
    }
}
