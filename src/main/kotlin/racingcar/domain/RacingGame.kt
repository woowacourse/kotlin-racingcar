package racingcar.domain

import kotlin.random.Random


class RacingGame(val cars: List<Car>, private val tryCounts: Int) {

    fun start() {
        repeat(tryCounts) {
            playRound()
        }
    }

    private fun playRound() {
        cars.forEach {
            val randomNumber = Random.nextInt(10)
            if (randomNumber >= 4) it.move()
        }
    }
}