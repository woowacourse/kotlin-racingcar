package controller
import model.Cars
import util.Validator
import view.InputView
import view.OutputView

class RaceGame {
    private val outputView = OutputView()
    private val inputView = InputView()

    private fun tryMove(cars: Cars) {
        for (pos in 0 until cars.getCarSize()) {
            cars.move(pos)
            outputView.outputResult(cars.getCar(pos))
        }
    }

    private fun equalMaxValue(cars: Cars): List<String> {
        return cars.findWinners()
    }

    fun run() {
        val cars = executeInputCarNames()
        val tryNumber = executeInputTryNumber()
        outputView.outputResults()
        for (i in 1..tryNumber) {
            tryMove(cars)
            println()
        }
        outputView.outputWinners(equalMaxValue(cars))
    }

    private fun executeInputTryNumber(): Int {
        outputView.outputTryNumber()
        return getInputTryNumber(inputView.inputTryNumber())
    }

    private fun getInputTryNumber(number: String?): Int {
        try {
            Validator().checkTryNumber(number)
            return number!!.toInt()
        } catch (e: IllegalArgumentException) {
            outputView.outputErrorMessage(e)
            return executeInputTryNumber()
        }
    }

    private fun executeInputCarNames(): Cars {
        outputView.outputCarNames()
        return getInputCarNames(inputView.inputCarNames())
    }
    private fun getInputCarNames(cars: String?): Cars {
        return try {
            Validator().checkNames(cars)
            Cars(cars!!)
        } catch (e: IllegalArgumentException) {
            outputView.outputErrorMessage(e)
            executeInputCarNames()
        }
    }
}
