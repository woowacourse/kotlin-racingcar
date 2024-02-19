package controller

import domain.Cars
import domain.MoveStrategy
import domain.TryCount
import view.InputView
import view.OutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val moveStrategy: MoveStrategy,
) {
    fun start() {
        val cars = inputWithRetry { readCars() }
        val tryCount = inputWithRetry { readTryCount() }

        race(cars, tryCount)
    }

    private fun readCars(): Cars = Cars.from(inputView.readCars())

    private fun readTryCount(): TryCount = TryCount.from(inputView.readTryCount())

    private fun race(
        cars: Cars,
        tryCount: TryCount,
    ) {
        outputView.printResultHeader()
        repeat(tryCount.count) {
            cars.startPhaseWith(moveStrategy)
            outputView.printPhase(cars)
        }
        outputView.printWinner(cars)
    }

    // Implementing recursively, a very large maxRetries can potentially lead to a stack overflow exception.
    private fun <T> inputWithRetry(
        maxRetries: Int = MAX_TRY_COUNT,
        block: () -> T,
    ): T {
        var retries = 1

        fun retry(): T =
            runCatching {
                block()
            }.getOrElse { e ->
                outputView.showExceptionMessage(e)
                check(retries < maxRetries) { EXCEPTION_EXCEED_TRY_COUNT }
                retries++
                retry()
            }
        return retry()
    }

    companion object {
        private const val MAX_TRY_COUNT = 5
        private const val EXCEPTION_EXCEED_TRY_COUNT = "최대 시도 횟수 ($MAX_TRY_COUNT 회) 를 초과했습니다."
    }
}
