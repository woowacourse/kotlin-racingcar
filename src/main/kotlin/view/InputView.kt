package view

object InputView {
    fun inputName(): String {
        OutputView.printCar()
        return readln()
    }

    fun inputTryCount(): String {
        OutputView.printTryCount()
        return readln()
    }
}
