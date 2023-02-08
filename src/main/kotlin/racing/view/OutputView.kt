package racing.view

import racing.model.Car

object OutputView {

    fun printCurrentPosition(cars: List<Car>) {
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
