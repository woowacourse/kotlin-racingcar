package view

import domain.Car

object OutputView {

    fun printMessage(message: String) = println(message)
    fun printGameStatus(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${carAdvanceState(car)}")
        }
        println()
    }

    private fun carAdvanceState(car: Car) = ADVANCE_STEP.repeat(car.advanceCount)

    fun printGameResult(winCars: List<Car>) =
        println(GAME_RESULT_FORMAT.format(winCars.joinToString(", ") { it.name }))

    private const val ADVANCE_STEP = "-"
    private const val GAME_RESULT_FORMAT = "최종 우승자: %s"
}
