package view

import domain.Car

private const val POSITION_MARK = "-"

object OutputView {
    fun showResult() = println("실행 결과")

    fun showCars(cars: List<Car>) {
        cars.map { car -> car.position() }
                .forEach { position -> println(POSITION_MARK.repeat(position)) }
        println()
    }
}