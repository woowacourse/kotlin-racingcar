package racingcar.domain.car

import racingcar.domain.Position
import java.util.*

const val RANDOM_BOUND_TO = 10

class Cars(val cars: List<Car>) {

    init {
        val distinctSize = cars.distinctBy { it.name }.size
        require(cars.size == distinctSize) { "중복된 이름을 사용할 수 없습니다." }
    }

    fun moveCars() {
        cars.forEach {
            it.tryToMove(random.nextInt(RANDOM_BOUND_TO))
        }
    }

    fun findWinners(): Cars {
        val maxPosition = findMaxPosition()
        val winners = cars.filter { it.isIn(maxPosition) }
        return Cars(winners)
    }

    private fun findMaxPosition(): Position {
        val maxValue = cars.map { it.position() }.max() ?: 0
        return Position(maxValue)
    }

    companion object Random {
        private val random = Random()
    }
}

