package racingcar.controller

import racingcar.model.Car
import racingcar.model.findWinnerNames
import racingcar.model.racingCars
import racingcar.view.*
import java.nio.file.Files.move


fun game() {
    var carNames: MutableList<String>
    try {
        carNames = inputCarName()
    } catch (e: Exception) {
        println("[ERROR] 자동차 이름은 5글자를 초과할 수 없습니다.")
        carNames = inputCarName()
    }
    val count = inputTryCnt()
    var cars = mutableListOf<Car>()
    for (carName in carNames) {
        cars.add(Car(carName))
    }
    run(count, cars)
}

fun inputCarName(): MutableList<String> {
    inputCar()
    val read = readLine().toString()
    var carNames = read.split(",").map { it.trim() }
    for (name in carNames) {
        require(name.length <= 5)
    }
    return carNames.toMutableList()
}

fun inputTryCnt(): Int {
    inputTry()
    var count = 0
    try {
        count = readLine()!!.toInt()
    } catch (e: NumberFormatException) {
        println("숫자만 입력 해주세요")
        count = inputTryCnt()
    }
    return count
}

fun run(count: Int, cars: MutableList<Car>) {
    printRunMenu()
    for (i in 1..count) racingCars(cars)

    val winners = findWinnerNames(cars)
    printWinners(winners)
}