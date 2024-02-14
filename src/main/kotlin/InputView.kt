object InputView {
    fun inputCarNames(input: String = readln()): List<String> = input.split(",")

    fun inputTrialCount(input: String = readln()): Int = input.toInt()
}