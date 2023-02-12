package view

import domain.Car

object OutputView {

    fun printMessage(message: String) = println(message)
    fun printGameStatus(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${car.getAdvancedStatusBar()}")
        }
        println()
    }

    fun printGameResult(winCars: List<Car>) =
        println(GAME_RESULT_FORMAT.format(winCars.joinToString(", ") { it.name }))
}

private fun Car.getAdvancedStatusBar() = "-".repeat(this.advancedCount)

private const val GAME_RESULT_FORMAT = "최종 우승자: %s"
