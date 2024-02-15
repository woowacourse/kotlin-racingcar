package racingcar.controller

import racingcar.model.Car
import racingcar.model.move
import racingcar.view.inputCarName
import racingcar.view.inputTryCnt


fun run() {
    val carNames = inputCarName().split(",").map { it.trim() }
    val count = inputTryCnt()
    var cars = mutableListOf<Car>()
    for (carName in carNames) {
        cars.add(Car(carName))
    }
    for (i in 0..count) move(cars)
}