import domain.cars.Cars
import domain.numbergenerator.RandomNumberGenerator
import view.InputView
import view.OutputView

class RacingCar {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val randomNumberGenerator = RandomNumberGenerator()
    private val inputValidator = InputValidator()

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
        val carName = inputView.readCarName()
        inputValidator.validateName(carName)
        return Cars(carName)
    }

    private fun getTryCount(): Int {
        val tryCount = inputView.readTryCount()
        inputValidator.validateTryCount(tryCount)
        return tryCount.toInt()
    }
}

fun main() {
    RacingCar().play()
}
