import view.InputView
import view.OutputView

fun main() {
    OutputView.askNumberOfCar()
    val numberOfCars = InputView.inputNumber()
    OutputView.askNumberOfCar()
    val numberOfRounds = InputView.inputNumber()
}

