package model.generator

import model.Car

class CarGenerator {

    fun generateCars(names: List<String>) = names.map { name ->
        Car(name)
    }
}
