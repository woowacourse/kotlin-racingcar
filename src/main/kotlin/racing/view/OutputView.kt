package racing.view

import racing.model.Car

class OutputView {
    fun printResult(cars: List<Car>, maxMoveCount: Int) {
        println("실행 결과")
        repeat(maxMoveCount) {
            printCurrentPosition(cars)
        }
    }

    private fun printCurrentPosition(cars: List<Car>) {
        for (car in cars) {
            println("${car.getName()} : ${getDash(car.getPosition())}")
        }
        println()
    }

    private fun getDash(position: Int): String {
        val result = StringBuilder()
        repeat(position) {
            result.append("-")
        }
        return result.toString()
    }
}
