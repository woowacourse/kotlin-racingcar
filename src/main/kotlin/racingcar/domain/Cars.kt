package racingcar.racingcar.domain

import racingcar.domain.Car

class Cars(names: List<String>) {
    var cars = listOf<Car>()
        private set
    val names: List<String>
        get() = cars.map { it.name }
    val locations: List<Int>
        get() = cars.map { it.location }
    val maxLocation: Int
        get() = cars.maxOf { it.location }

    init {
        cars = names.map { Car(it) }
    }
}
