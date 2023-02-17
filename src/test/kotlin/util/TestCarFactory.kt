package util

import domain.Car
import domain.Driver

object TestCarFactory {
    fun makeCars(carNames: List<String>, randNums: List<Int>): List<Car> {
        return carNames.mapIndexed { idx, name ->
            Car(name, makeDriver(randNums[idx]))
        }
    }

    fun makeCars(carNames: List<String>, randNum: Int): List<Car> {
        return carNames.map { Car(it, makeDriver(randNum)) }
    }

    fun makeCar(carName: String, randNum: Int): Car {
        return Car(carName, makeDriver(randNum))
    }

    private fun makeDriver(randNum: Int): Driver {
        return Driver(TestNumberGenerator(randNum))
    }
}
