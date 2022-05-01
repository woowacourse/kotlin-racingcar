package racingcar.view

import racingcar.domain.Car
import java.util.stream.Collectors

object OutputView {

    private const val DISTANCE_REPRESENT = "-"

    fun printIntroduction() {
        println("실행 결과")
    }

    fun printProcess(cars: List<Car>) {
        for (car in cars) {
            println("${car.name.value} : ${DISTANCE_REPRESENT.repeat(car.position.distance)}")
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.stream()
            .map { it.name.value }
            .collect(Collectors.joining(", "))
        println("$winnerNames 가 최종 우승했습니다.")
    }
}
