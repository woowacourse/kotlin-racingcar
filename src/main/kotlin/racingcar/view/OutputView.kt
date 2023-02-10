package racingcar.view

import racingcar.domain.Car

class OutputView {
    fun printCarsState(cars: List<Car>) {
        cars.forEach { car ->
            printCarState(car.name, car.location)
        }
        println()
    }

    private fun printCarState(carName: String, carLocation: Int) {
        println(carName + " : " + "-".repeat(carLocation))
    }

    fun printResult() {
        println(OUTPUT_RESULT)
    }

    fun printWinner(carNames: List<String>) {
        print(OUTPUT_WINNER + carNames.joinToString(", "))
    }

    companion object {
        private const val OUTPUT_RESULT = "실행 결과"
        private const val OUTPUT_WINNER = "최종 우승자: "
    }
}
