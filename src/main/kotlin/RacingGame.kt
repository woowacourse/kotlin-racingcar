import domain.cars.Cars
import domain.numbergenerator.RandomNumberGenerator
import view.InputView
import view.OutputView

class RacingGame {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun play() {
        val cars = getCars()
        val tryCount = getTryCount()
        outputView.showResult()
        repeat(tryCount) {
            cars.lap(RandomNumberGenerator.generate())
            outputView.showStatus(cars)
        }
        outputView.showWinners(cars.getWinners())
    }

    private fun getCars(): Cars {
        val carName = inputView.readCarName()
        InputValidator.validateCarName(carName)
        val carsArgument = RacingCarConverter.toCarsArgument(carName)
        return Cars(carsArgument)
    }

    private fun getTryCount(): Int {
        val tryCount = inputView.readTryCount()
        InputValidator.validateTryCount(tryCount)
        return tryCount.toInt()
    }
}

fun main() {
    RacingGame().play()
}
