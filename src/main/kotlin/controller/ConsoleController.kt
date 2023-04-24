package controller

import domain.Cars
import domain.NumberGenerator
import domain.RandomNumberGenerator
import domain.TrialCount
import view.InputView
import view.OutputView
import java.util.function.Supplier

class ConsoleController(private val inputView: InputView, private val outputView: OutputView) {

    companion object {
        val trialCountRange = { trialCount: Int -> 1..trialCount }
    }

    fun run() {
        val cars = repeatUntilReturnValue { Cars(inputView.readCarNames()) }
        val trialCount = repeatUntilReturnValue { TrialCount(inputView.readTrialCount()) }

        outputView.printRoundResultHeader()
        playGame(cars, trialCount, RandomNumberGenerator())

        outputView.printGameResult(cars.findWinners())
    }

    private fun playGame(cars: Cars, trialCount: TrialCount, numberGenerator: NumberGenerator) {
        for (count in trialCountRange(trialCount.value)) {
            cars.moveCars(numberGenerator)
            outputView.printRoundResult(cars.cars)
        }
    }

    private fun <T> repeatUntilReturnValue(supplier: Supplier<T>): T {
        return kotlin.runCatching {
            supplier.get()
        }.getOrElse {
            outputView.printErrorMessage(it.message ?: "예기치 못한 예외가 발생했습니다.")
            repeatUntilReturnValue(supplier)
        }
    }
}
