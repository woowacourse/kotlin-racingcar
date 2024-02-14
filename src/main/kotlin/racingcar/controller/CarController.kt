package racingcar.controller

import racingcar.Validator
import racingcar.model.Car
import racingcar.view.InputView

class CarController(
    private val inputView: InputView,
    private val validator: Validator
) {
    fun run() {
        val cars = registerCars()
        val numberOfRound = registerRound()
    }

    private fun registerCars(): List<Car> {
        val carNames = inputView.inputCarNames()
        return try {
            validator.validateCarNames(carNames)
            makeCars(carNames)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            registerCars()
        }
    }

    private fun makeCars(carNames: List<String>): List<Car> {
        return carNames.map { name ->
            Car(name = name)
        }
    }

    private fun registerRound(): Int {
        val numberOfRound = inputView.inputNumberOfRound()
        return try {
            validator.validateNumberOfRound(numberOfRound)
            numberOfRound.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            registerRound()
        }
    }
}
