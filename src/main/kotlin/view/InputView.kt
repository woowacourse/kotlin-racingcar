package view

private const val SEPARATOR = ","

class InputView {
    fun enterCarName(): List<String>? {
        return readLine()?.split(SEPARATOR)
    }

    fun enterCount(): Int? {
        return readLine()?.toInt()
    }
}
