package racingcar.view

import racingcar.domain.Car

class OutputView {
    fun printRaceResult(cars: List<Car>) {
        println(RESULT_PREFIX)
        var names = cars.map { car -> car.name }.toList()
        var locations = cars.map { car -> car.location }.toList()
        cars.forEach { car ->
            printCarsState(names, locations)
        }
    }

    private fun printCarsState(names: List<String>, locations: List<Int>) {
        locations.forEachIndexed { i, _ ->
            printCarState(names[i], locations[i])
        }
        println()
    }

    private fun printCarState(name: String, location: Int) {
        println("$name : ${"-".repeat(location)}")
    }

    fun printWinner(names: List<String>) {
        print(WINNER + names.joinToString(", "))
    }

    companion object {
        private const val RESULT_PREFIX = "실행 결과"
        private const val WINNER = "최종 우승자: "
    }
}
