package controller

import domain.Cars
import domain.NumberGenerator
import domain.RandomNumberGenerator
import domain.TrialCount
import view.InputView
import view.OutputView
import java.util.function.Supplier

class ConsoleController {

    companion object {
        val trialCountRange = { trialCount: Int -> 1..trialCount }
    }

    fun run() {
        val cars = repeatUntilReturnValue { Cars(InputView.readCarNames()) }
        val trialCount = repeatUntilReturnValue { TrialCount(InputView.readTrialCount()) }

        OutputView.printRoundResultHeader()
        playGame(cars, trialCount, RandomNumberGenerator())

        OutputView.printGameResult(cars.findWinners())
    }

    private fun playGame(cars: Cars, trialCount: TrialCount, numberGenerator: NumberGenerator) {
        for (count in trialCountRange(trialCount.value)) {
            cars.moveCars(numberGenerator)
            OutputView.printRoundResult(cars.cars)
        }
    }

    private fun <T> repeatUntilReturnValue(supplier: Supplier<T>): T {
        return kotlin.runCatching {
            supplier.get()
        }.getOrElse {
            OutputView.printErrorMessage(it.message ?: "예기치 못한 예외가 발생했습니다.")
            repeatUntilReturnValue(supplier)
        }
    }
}
