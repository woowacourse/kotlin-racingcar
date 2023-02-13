package domain.generator

import model.Car

class CarGenerator {

    fun generateCars(
        names: List<String>,
        numberGenerator: () -> Int = {
            (MINIMUM_NUMBER..MAXIMUM_NUMBER).random()
        }
    ) = names.map { name ->
        Car(name, numberGenerator)
    }

    companion object {
        const val MINIMUM_NUMBER = 0
        const val MAXIMUM_NUMBER = 9
    }
}
