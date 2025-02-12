package view

class InputView {
    fun getUserInput(): String {
        val input = readln().trim()
        return input
    }
}
