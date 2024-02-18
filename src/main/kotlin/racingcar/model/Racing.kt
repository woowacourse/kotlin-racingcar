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
        var maxNum = -1
        var winners = mutableListOf<String>()
        for (car in cars) {
            maxNum = winnerJudge(car, maxNum, winners)
        }

        return winners
    }

    private fun winnerJudge(
        car: Car,
        tmp: Int,
        winners: MutableList<String>,
    ): Int {
        val len = car.position
        val num = len.coerceAtLeast(tmp)
        if (tmp < num) {
            winners.apply {
                clear()
                add(car.name)
            }
        } else if (tmp == len) {
            winners.add(car.name)
        }
        return num
    }

    companion object {
        const val START_RANGE = 0
        const val END_RANGE = 9
        const val TARGET_NUM = 4
        const val MOVE = 1
        const val STOP = 0
    }
}
