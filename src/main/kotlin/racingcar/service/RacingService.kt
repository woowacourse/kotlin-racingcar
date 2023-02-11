package racingcar.service

import racingcar.model.Round
import racingcar.model.car.Car
import racingcar.model.car.Cars

class RacingService(carNames: List<String>) {
    private val cars = Cars(carNames.map { Car(it) })

    fun runAllRounds(round: Round, doEachRoundResult: (Cars) -> Unit) {
        repeat(round.count) {
            doEachRoundResult(moveCarsRandomly())
        }
    }

    private fun moveCarsRandomly(): Cars =
        cars.moveAllRandomly()

    fun getWinners(): List<Car> =
        cars.getWinners()
}
