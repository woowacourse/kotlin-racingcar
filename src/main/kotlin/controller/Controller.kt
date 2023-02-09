package controller

import domain.Car
import view.InputView
import view.OutputView

class Controller(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var cars: List<Car>
    private var time = 0

    fun run() {
        setUp()
    }

    private fun setUp() {
        setUpCars()
        setUpRaceTime()
        outputView.printInterval()
    }

    private fun setUpCars() {
        while (true) {
            try {
                cars = inputView.readCars().getCars()
                return
            } catch (e: IllegalArgumentException) {
                outputView.printError(e.message ?: "")
            }
        }
    }

    private fun setUpRaceTime() {
        while (true) {
            try {
                time = inputView.readRaceTime().getRaceTime()
                return
            } catch (e: IllegalArgumentException) {
                outputView.printError(e.message ?: "")
            }
        }
    }

    private fun race() {}

    private fun announceWinners() {}
}
