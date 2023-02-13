package domain

import model.Car
import model.generator.CarGenerator

class InputRefinement(
    private val carGenerator: CarGenerator = CarGenerator()
) {

    fun initCars(input: String): List<Car> {
        val names = input.split(SEPARATOR)

        return carGenerator.generateCars(names)
    }

    fun initNumberOfTry(numberOfTry: String): Int {
        InputValidator.validateIsNumeric(numberOfTry)

        return numberOfTry.toInt()
    }

    companion object {
        const val SEPARATOR = ','
    }
}
