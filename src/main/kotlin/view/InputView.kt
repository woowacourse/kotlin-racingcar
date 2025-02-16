package view

object InputView {
    fun getUserInput(): String {
        val input = readln().trim()
        return input
    }
}
