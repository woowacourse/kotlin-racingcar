package racingcar.racingcar.domain

import racingcar.domain.Car

class Cars(cars: List<Car>) {
    var cars = cars
        private set
    val maxLocation: Int
        get() = cars.maxOf { it.location }

    constructor(names: List<String>) : this(names.map { Car(it) })
}
