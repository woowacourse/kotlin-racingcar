import java.util.Scanner

class InputView {

    private val scanner = Scanner(System.`in`)

    fun readCarName(): String {
        println(Constants.INPUT_CAR_NAME_MESSAGE)
        return scanner.nextLine()
    }

    fun readTryCount(): String {
        println(Constants.INPUT_TRY_COUNT_MESSAGE)
        return scanner.nextLine()
    }

}
