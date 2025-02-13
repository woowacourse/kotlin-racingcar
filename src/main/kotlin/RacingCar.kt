import domain.cars.Cars
import domain.numbergenerator.RandomNumberGenerator
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
            cars.lap(randomNumberGenerator)
            outputView.showStatus(cars)
        }
        outputView.showWinners(cars.getWinners())
    }

    private fun getCars(): Cars {
        val carName = inputView.readCarName()
        InputValidator.validateCarName(carName)
        return Cars(carName)
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
