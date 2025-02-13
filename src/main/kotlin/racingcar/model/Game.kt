package racingcar.model

import racingcar.enums.Move

class Game(
    private val cars: List<Car>,
    private val rounds: Int,
) {
    fun play() {
        repeat(rounds) {
            playRound()
        }
    }

    private fun playRound() {
        cars.forEach { car ->
            val randomNumber = makeRandomNumber()
            when (randomNumber) {
                Move.MOVABLE -> {}
                Move.UNMOVABLE -> {}
            }
        }
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
