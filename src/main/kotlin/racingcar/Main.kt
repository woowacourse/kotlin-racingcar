package racingcar

import racingcar.view.View

fun main() {
    val view = View()
    val cars: List<Car> = view.readCars()
    val round: Int = view.readRound()
    println("\n실행결과")
    val racecourse = Racecourse(cars, round)
    racecourse.startRace()
}
