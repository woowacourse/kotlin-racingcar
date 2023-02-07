class InputView {
    fun carNames(): List<String> {
        val input = readLine()
        val names = input?.split(",")
        if (names != null) {
            return names
        }
        return listOf()
    }

    fun attemptCount(): Int {
        val input = readLine()
        if (input != null) {
            return input.toInt()
        }
        return 0
    }
}
