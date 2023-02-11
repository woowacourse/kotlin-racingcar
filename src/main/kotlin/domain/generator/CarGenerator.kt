package domain.generator

import data.Car

class CarGenerator {

    fun generateCars(names: List<String>) = names.map { name ->
        Car(name)
    }
}
