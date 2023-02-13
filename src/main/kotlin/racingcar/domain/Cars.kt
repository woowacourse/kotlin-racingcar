package racingcar.racingcar.domain

import racingcar.domain.Car

class Cars(private val cars: List<Car>) : List<Car> by cars {
    val maxLocation: Int
        get() = cars.maxOf { it.location }

    companion object {
        fun create(carNames: List<String>): Cars {
            return Cars(carNames.map { Car(it) })
        }
    }
}
