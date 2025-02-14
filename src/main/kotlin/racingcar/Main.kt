package racingcar

import racingcar.view.View

fun main() {
    val view = View()

    val cars: List<Car> = view.readCars()
    val round: Int = view.readRound()

    view.showResult(cars, round)
}
