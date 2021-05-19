package racingcar.domain

import org.jetbrains.annotations.TestOnly
import kotlin.random.Random

class Cars(private val carNum: Int) {
    private val cars: ArrayList<Car> = ArrayList()

    fun cars(): List<Car> {
        return cars.toList()
    }

    init {
        for (i in 0 until carNum) {
            cars.add(Car(RandomMoveStrategy()))
        }
    }
}