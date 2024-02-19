package racingcar.view

import racingcar.model.Car
import racingcar.model.RacingGame

class OutputView {
    fun printEachCarsPosition(
        numberOfAttempts: Int,
        cars: MutableList<Car>,
    ) {
        val racingGame = RacingGame(cars)
        println(InputView.EXECUTION_RESULTS)
        repeat(numberOfAttempts) {
            racingGame.carMovingControl()
            cars.forEach {
                println("${it.name}: ${it.position}")
            }
            println()
        }
    }

    fun printFinalWinners(finalWinners: List<String>) {
        print(InputView.LAST_WINNER)
        print(finalWinners.joinToString(FINAL_WINNER_PRINT_SEPARATOR))
    }

    companion object {
        const val FINAL_WINNER_PRINT_SEPARATOR = ","
    }
}
