package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars

fun showNameInputMessage() {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
}

fun showCountInputMessage() {
    println("시도할 회수는 몇회인가요?")
}

fun showCarsPosition(cars: Cars) {
    println(
        cars.values.joinToString(separator = "\n") { "${it.name} : ${"-".repeat(it.position)}" }
    )
    println()
}

fun showWinners(winners: List<Car>) {
    println("${winners.joinToString { it.name }}가 최종 우승했습니다.")
}
