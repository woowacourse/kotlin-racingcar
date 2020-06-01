package domain

import java.util.*
import kotlin.collections.ArrayList

class Cars(cars: List<Car> = Collections.emptyList()) {
    private val cars: List<Car>

    init {
        this.cars = ArrayList(cars)
    }

    fun move() {
        for (car in cars) {
            car.move()
        }
    }

    fun values() = Collections.unmodifiableList(cars)
}
