package controller
import model.Cars
import util.Validator
import view.InputView
import view.OutputView

class RaceGame {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun run() {
        val cars = executeInputCarNames()
        val tryNumber = executeInputTryNumber()
        outputView.outputResults()
        repeat(tryNumber) {
            tryMove(cars)
        }
        outputView.outputWinners(cars.findWinners())
    }

    private fun tryMove(cars: Cars) {
        for (pos in 0 until cars.getCarSize()) {
            cars.move(pos)
            outputView.outputResult(cars.getCarInfo(pos))
        }
        outputView.outputNextLine()
    }

    private fun executeInputTryNumber(): Int {
        outputView.outputTryNumber()
        return getInputTryNumber(inputView.inputTryNumber())
    }

    private fun getInputTryNumber(number: String): Int {
        return try {
            Validator().checkTryNumber(number)
            number.toInt()
        } catch (e: IllegalArgumentException) {
            outputView.outputErrorMessage(e.message ?: "에러가 발생했습니다.")
            executeInputTryNumber()
        }
    }

    private fun executeInputCarNames(): Cars {
        outputView.outputCarNames()
        return getInputCarNames(inputView.inputCarNames())
    }

    private fun getInputCarNames(cars: String): Cars {
        return try {
            Validator().checkNames(cars)
            Cars(cars)
        } catch (e: IllegalArgumentException) {
            outputView.outputErrorMessage(e.message ?: "에러가 발생했습니다.")
            executeInputCarNames()
        }
    }
}
