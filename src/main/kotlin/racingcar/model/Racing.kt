package racingcar.model

class Racing {
    fun racingCars(cars: List<Car>) {
        for (car in cars) {
            val randomNum = rand()
            car.move(goOrStop(randomNum))
        }
    }

    fun rand() = (START_RANGE..END_RANGE).random()

    fun goOrStop(num: Int): Int {
        return if (num >= TARGET_NUM) MOVE else STOP
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
        const val MOVE = 1
        const val STOP = 0
    }
}
