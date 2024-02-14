package racingcar.controller

import racingcar.Validator
import racingcar.model.Car
import racingcar.view.InputView

class CarController(
    private val inputView: InputView,
    private val validator: Validator
) {
    private var cars: List<Car> = emptyList()

    fun run() {
        registerCarNames()
    }

    private fun registerCarNames() {
        while (cars.isEmpty()) {
            try {
                val carNames = inputView.inputCarNames()
                validator.validateCarNames(carNames)
                registerCars(carNames)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun registerCars(carNames: List<String>) {
        cars = carNames.map { name ->
            Car(name = name)
        }
    }
}
