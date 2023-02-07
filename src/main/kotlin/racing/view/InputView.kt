package racing.view

class InputView {
    fun inputCarName(): String {
        val userInput = readLine()
        return userInput!!
    }

    fun inputCount(): Int {
        val userInput = readLine()
        return userInput!!.toInt()
    }
}
