package racingcar.controller

import racingcar.domain.Car
import racingcar.view.InputView

class RacingManager {
    private val input by lazy { InputView() }
    private lateinit var cars: List<Car>
    private var racingCount = 0

    fun setGame() {
        cars = input.inputCarNames().map { Car(it) }
        racingCount = input.inputRacingCount()
    }
}
