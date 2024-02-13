object InputView {
    fun inputCars(names: String = readln()) = names.split(",")
    fun inputTrialCount(count: String = readln()) = count.toInt()
}