package racingcar.model

import racingcar.enums.Move

class Game(private val cars: List<Car>) {
    fun playRound() {
        cars.forEach { car ->
            val randomNumber = makeRandomNumber()
            when (randomNumber) {
                Move.MOVABLE -> car.move()
                Move.UNMOVABLE -> return
            }
        }
    }

    fun getRoundResult(): List<Pair<String, Int>> {
        return cars.map { car ->
            car.name to car.position
        }.toList()
    }

    private fun makeRandomNumber(): Move {
        val random = (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).random()
        return Move.create(random)
    }

    companion object {
        const val MIN_RANDOM_NUMBER = 0
        const val MAX_RANDOM_NUMBER = 9
    }
}
