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
}
