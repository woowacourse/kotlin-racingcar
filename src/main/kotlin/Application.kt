import controller.RacingController
import domain.Car
import validator.InputValidator.validateCarName
import validator.InputValidator.validateTryNumber
import view.InputView
import view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val racingController = RacingController()

    val carNames: List<String> = inputView.inputCarNames().split(',').map { it.trim() }
    carNames.map { validateCarName(it) }
    val cars: List<Car> = carNames.map { Car(it) }
    val tryNumber: Int = validateTryNumber(inputView.inputTryNumber())

    outputView.printStatus()
    repeat(tryNumber) {
        racingController.playRace(cars)
        outputView.printCars(cars)
    }
    outputView.printResult(racingController.getWinners(cars))
}
