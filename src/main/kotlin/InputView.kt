import java.util.Scanner

class InputView {
    private val scanner = Scanner(System.`in`)

    fun readCars(): String {
        println(INPUT_CAR_NAME)
        return scanner.nextLine()
    }

    fun readAttempt(): String {
        println(INPUT_ATTEMPTS)
        return scanner.nextLine()
    }
}
