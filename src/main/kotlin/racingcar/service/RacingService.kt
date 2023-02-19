package racingcar.service

import racingcar.domain.Car
import racingcar.utils.Random

class RacingService {

    fun moveRandomly(car: Car) {
        if (isMove(pickRandomMoveProbability())) car.takeOneStepForward()
    }

    fun isMove(moveProbability: Int): Boolean {
        return moveProbability >= MOVEMENT_PROBABILITY
    }

    private fun pickRandomMoveProbability(): Int {
        return Random.pickInRange(START_RANDOM_MOVEMENT_PROBABILITY, END_RANDOM_MOVEMENT_PROBABILITY)
    }

    companion object {
        private const val START_RANDOM_MOVEMENT_PROBABILITY = 0
        private const val END_RANDOM_MOVEMENT_PROBABILITY = 9
        private const val MOVEMENT_PROBABILITY = 4
    }
}
