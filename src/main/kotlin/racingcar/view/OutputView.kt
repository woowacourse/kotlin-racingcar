package racingcar.view

import racingcar.model.Car
import racingcar.model.RandomNumberGenerator

class OutputView {
    fun printEachCarsPosition(
        numberOfAttempts: Int,
        cars: MutableList<Car>
    ) {
        println(InputView.EXECUTION_RESULTS)
        repeat(numberOfAttempts) {
            cars.forEach { car ->
                val randomNumber = RandomNumberGenerator.generateRandomNumber()
                car.moveCar(randomNumber)
            }
            cars.forEach {
                println("${it.name}: ${it.position}")
            }
            println()
        }
    }
    fun printFinalWinners(finalWinners: List<String>){
        print(InputView.LAST_WINNER)
        print(finalWinners.joinToString(FINAL_WINNER_PRINT_SEPARATOR))
    }

    companion object{
        const val FINAL_WINNER_PRINT_SEPARATOR = ","
    }
}
