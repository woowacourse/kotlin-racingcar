package view

class InputView {
    fun getUserInput(message: String): String {
        println(message)
        return readln()
    }
}
