package racingcar.view

import racingcar.domain.Car

object OutputView {

    fun showWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") {
            it.name.value
        }
        println("$winnerNames 우승 축하!")
    }
}
