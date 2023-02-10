package controller
import model.Cars
import util.CarsHelper
import util.Validator
import view.InputView
import view.OutputView

class RaceGame(private val outputView: OutputView, private val inputView: InputView) {

    fun run() {
        val cars = executeInputCarNames()
        val tryNumber = executeInputTryNumber()
        outputView.outputResults()
        repeat(tryNumber) {
            tryMove(cars)
        }
        outputView.outputWinners(CarsHelper.findWinners(cars))
    }

    private fun tryMove(cars: Cars) {
        repeat(cars.getCarSize()) {
            cars.move(it)
            outputView.outputResult(cars.getCarInfo(it))
        }
        outputView.outputNextLine()
    }

    private fun executeInputTryNumber(): Int {
        var result: Int?
        do {
            outputView.outputTryNumber()
            result = getInputTryNumber(inputView.inputTryNumber())
        } while (result == null)
        return result
    }

    private fun getInputTryNumber(number: String): Int? {
        return runCatching {
            Validator().checkTryNumber(number)
            number.toInt()
        }.onFailure {
            outputView.outputErrorMessage(it.message ?: "에러가 발생했습니다.")
        }.getOrNull()
    }

    private fun executeInputCarNames(): Cars {
        var result: Cars?
        do {
            outputView.outputCarNames()
            result = getInputCarNames(inputView.inputCarNames())
        } while (result == null)
        return result
    }

    private fun getInputCarNames(cars: String): Cars? {
        return runCatching {
            Validator().checkNames(cars)
            Cars(cars)
        }.onFailure {
            outputView.outputErrorMessage(it.message ?: "에러가 발생했습니다.")
        }.getOrNull()
    }
}
