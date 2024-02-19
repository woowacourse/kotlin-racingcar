package racingcar.model

import racingcar.RandomMoveStrategy
import kotlin.random.Random

class Racing : RandomMoveStrategy {
    fun racingCars(cars: List<Car>) {
        for (car in cars) {
            if (shouldMove(START_RANGE, END_RANGE)) car.move()
        }
    }

    fun findWinnerNames(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }

        return winners
    }

    companion object {
        const val START_RANGE = 0
        const val END_RANGE = 9
        const val TARGET_NUM = 4
    }

    override fun shouldMove(
        minNum: Int,
        maxNum: Int,
    ): Boolean {
        return Random.nextInt(minNum, maxNum) >= TARGET_NUM
    }
}
