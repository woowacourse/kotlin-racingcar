package racing.view

object InputView {
    fun inputCarNames(): List<String> {
        val userInput = readLine()
        return userInput!!.split(",")
    }

    fun inputCount(): Int {
        val userInput = readLine()
        return userInput!!.toInt()
    }
}
