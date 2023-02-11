package controller
import model.Cars
import util.Validator
import view.InputView
import view.OutputView

class RaceGame {

    private val inputView = InputView()
    private val outputView = OutputView()

    private fun tryMove(cars: Cars) {
        cars.move()
        outputView.outputResult(cars)
    }

    private fun equalMaxValue(cars: Cars): List<String> {
        return cars.findWinners()
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
        outputView.outputWinners(equalMaxValue(cars))
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
            Cars.mappingCars(cars!!)
        }.onFailure { outputView.outputErrorMessage(it.message!!) }
            .getOrNull()
    }
}
