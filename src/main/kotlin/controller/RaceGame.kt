package controller
import generator.RandomNumberGenerator
import model.Cars
import util.Validator
import view.InputView
import view.OutputView

class RaceGame(private val inputView: InputView, private val outputView: OutputView) {

    private fun tryMove(cars: Cars) {
        cars.move()
        outputView.outputResult(cars)
    }

    fun run() {
        val cars = executeInputCarNames()
        val tryNumber = executeInputTryNumber()
        startGame(tryNumber, cars)
        endGame(cars)
    }

    private fun startGame(tryNumber: Int, cars: Cars) {
        outputView.outputResults()
        repeat(tryNumber) { tryMove(cars) }
    }

    private fun endGame(cars: Cars) {
        outputView.outputWinners(cars.findWinners())
    }

    private fun executeInputTryNumber(): Int {
        var result: Int?
        do {
            outputView.outputTryNumber()
            result = getInputTryNumber(inputView.inputTryNumber())
        } while (result == null)
        return result
    }

    private fun getInputTryNumber(number: String?): Int? {
        return runCatching {
            Validator().checkTryNumber(number)
            number!!.toInt()
        }.onFailure { outputView.outputErrorMessage(it.message!!) }
            .getOrNull()
    }

    private fun executeInputCarNames(): Cars {
        var result: Cars?
        do {
            outputView.outputCarNames()
            result = getInputCarNames(inputView.inputCarNames())
        } while (result == null)
        return result
    }
    private fun getInputCarNames(cars: String?): Cars? {
        return runCatching {
            Validator().checkNames(cars)
            Cars.mappingCars(cars!!, RandomNumberGenerator())
        }.onFailure { outputView.outputErrorMessage(it.message!!) }
            .getOrNull()
    }
}
