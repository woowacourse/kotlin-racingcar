import java.util.Scanner

class InputView {
    private val scanner = Scanner(System.`in`)

    fun readCars(): String {
        println(INPUT_CAR_NAME)
        return scanner.nextLine()
    }

    fun readAttempt(): Int {
        println(INPUT_ATTEMPTS)
        val attempts = scanner.nextLine()
        return requireNotNull(attempts.toIntOrNull()) { ATTEMPT_INPUT_ERROR }
    }
}
