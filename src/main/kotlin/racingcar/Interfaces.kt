package racingcar

interface RandomGenerator {
    fun nextInt(
        from: Int,
        until: Int,
    ): Int
}

interface OutputView {
    fun showMessage(
        message: String,
        endWithNewLine: Boolean = false,
    )

    fun showBlankLine()
}

interface InputView {
    fun readInput(): String
}
