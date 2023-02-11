package domain.generator

import model.Car

class CarGenerator {

    fun generateCars(
        names: List<String>,
        numberGenerator: NumberGenerator = RacingNumberGenerator()
    ) = names.map { name ->
        Car(name, numberGenerator)
    }
}
