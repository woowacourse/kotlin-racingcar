package racingcar.model

import racingcar.enums.Move

class Game(private val cars: List<Car>) {
    fun playRound() {
        cars.forEach { car ->
            val randomNumber = makeRandomNumber()
            val moveState = Move.create(randomNumber)
            car.move(moveState)
        }
    }

    fun getRoundResult(): List<RoundResult> {
        return cars.map { car ->
            RoundResult(car.name, car.position)
        }.toList()
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        return winners
    }

    private fun makeRandomNumber(): Int {
        return (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).random()
    }

    companion object {
        const val MIN_RANDOM_NUMBER = 0
        const val MAX_RANDOM_NUMBER = 9
    }
}
