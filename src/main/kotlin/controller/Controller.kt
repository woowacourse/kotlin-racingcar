package controller

import domain.Car
import view.InputView
import view.OutputView

class Controller(
    private val inputView: InputView,
    private val OutputView: OutputView
) {
    private lateinit var cars: List<Car>

    fun run() {}

    private fun setUp() {}

    private fun setUpCars() {
        while (true) {
            try {
                cars = inputView.readCars().getCars()
                return
            } catch (e: IllegalArgumentException) {
                OutputView.printError(e.message ?: "")
            }
        }
    }

    private fun setUpRaceTime() {}

    private fun race() {}

    private fun announceWinners() {}
}
