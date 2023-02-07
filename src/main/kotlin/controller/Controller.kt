package controller

import domain.Car
import utils.RepeatInputProcess
import view.InputView
import view.OutputView

class Controller(private val inputView: InputView, private val outputView: OutputView) {
    private var cars = mutableListOf<Car>()
    private var roundCount: Int = 0
    fun start() {
        initializeGame()
    }

    private fun initializeGame() {
        outputView.printCarNamesPrompt()
        val names = RepeatInputProcess.repeat { inputView.readCarNames() } as List<String>
        for (name in names) {
            cars.add(Car(name, 0))
        }
        outputView.printRoundCountPrompt()
        roundCount = RepeatInputProcess.repeat { inputView.readRoundCount() } as Int
    }

    private fun playGame() {
    }

    private fun finishGame() {
    }
}
