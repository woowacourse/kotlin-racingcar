package view

import domain.Car

class OutputView {
    fun printCars(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : " + "-".repeat(it.position))
        }
        println()
    }
}