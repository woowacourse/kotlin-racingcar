package racingcar.model

class RacingCarGame(private val cars: List<Car>) {
    fun race(): List<Car> = List(cars.size) { index -> move(index, getRandomNumber()) }

    fun move(
        index: Int,
        randomNumber: Int,
    ): Car {
        if (randomNumber >= MOVE_NUMBER) cars[index].move(STEP)
        return cars[index]
    }

    private fun getRandomNumber(): Int = (MIN_MOVE_NUMBER..MAX_MOVE_NUMBER).random()

    fun findWinners(): List<Car> {
        val maxDistance = cars.maxOf { it.distance }
        return cars.filter { car ->
            car.distance == maxDistance
        }
    }

    companion object {
        const val MOVE_NUMBER = 4
        const val MIN_MOVE_NUMBER = 0
        const val MAX_MOVE_NUMBER = 9

        const val STEP = 1
    }
}
