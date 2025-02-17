package racingcar

import racingcar.controller.RacingCarController
import racingcar.domain.Car

fun main() {
    val racingCarController = RacingCarController()
    racingCarController.start()
}

fun String.toCars(): List<Car> =
    split(",")
        .map { it.trim() }
        .filter { it.isNotBlank() }
        .map { name -> Car(name) }
