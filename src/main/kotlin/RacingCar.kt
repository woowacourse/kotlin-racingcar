import domain.cars.Car
import domain.cars.Cars
import domain.numbergenerator.RandomNumberGenerator
import view.InputView
import view.OutputView

class RacingCar {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val randomNumberGenerator = RandomNumberGenerator()

    fun play() {
        val cars = getCars()
        val tryCount = getTryCount()
        outputView.showResult()
        repeat(tryCount) {
            cars.moveAll(randomNumberGenerator)
            outputView.showStatus(cars)
        }
        outputView.showWinners(cars.getWinners())
    }

    private fun getCars(): Cars {
        val carNameInput = inputView.readName()
        val cars = InputValidator.validateName(carNameInput).map { Car(it) }
        return Cars(cars)
    }

    private fun getTryCount(): Int {
        val tryCount = inputView.readTryCount()
        InputValidator.validateTryCount(tryCount)
        return tryCount.toInt()
    }
}

fun main() {
    RacingCar().play()
}
