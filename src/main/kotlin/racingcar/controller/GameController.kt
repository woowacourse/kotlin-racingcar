package racingcar.controller

import racingcar.model.Car
import racingcar.model.findWinnerNames
import racingcar.model.racingCars
import racingcar.view.inputCar
import racingcar.view.inputTry
import racingcar.view.printRunMenu
import racingcar.view.printWinners

fun game() {
    val carNames = inputCarName()
    var cars = mutableListOf<Car>()
    val count = inputTryCnt()

    carNames.split(",").forEach { cars.add(Car(it)) }
    run(count, cars)
}

fun inputCarName(): String {
    val carNames = inputCar()
    return carNames
}

fun inputTryCnt(): Int {
    var count = 0
    try {
        count = inputTry()
    } catch (e: Exception) {
        println(e)
        count = inputTryCnt()
    }
    return count
}

fun run(
    count: Int,
    cars: MutableList<Car>,
) {
    printRunMenu()

    for (i in 1..count) {
        racingCars(cars)
    }

    val winners = findWinnerNames(cars)
    printWinners(winners)
}
