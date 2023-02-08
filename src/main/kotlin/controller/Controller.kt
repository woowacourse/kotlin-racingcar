package controller

import domain.Car
import domain.RandomNumberGenerator
import utils.RepeatInputProcess
import view.InputView
import view.OutputView

class Controller(private val inputView: InputView, private val outputView: OutputView) {
    private var cars = mutableListOf<Car>()
    private var roundCount: Int = 0
    fun start() {
        initializeGame()
        playGame()
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
        repeat(roundCount) {
            playOneRound()
        }
    }

    private fun playOneRound() {
        val generator = RandomNumberGenerator()
        for (car in cars) {
            val number = generator.generate()
            if (number >= 4) car.move()
        }
    }

    private fun finishGame() {
    }
}
