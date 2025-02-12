package view

import domain.Car

class OutputView {
    fun printStatus() {
        println("실행 결과")
    }

    fun printCars(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : " + "-".repeat(it.position))
        }
        println()
    }

    fun printResult(name: List<String>) {
        println(name.joinToString(", "))

    }
}