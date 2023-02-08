package controller

import domain.Car
import domain.RandomNumberGenerator
import utils.RepeatInputProcess
import view.InputView
import view.OutputView

class Controller(private val inputView: InputView, private val outputView: OutputView) {
    fun start() {
        val cars = initializeCars()
        playGame(cars, initializeRoundCount())
        finishGame(cars)
    }

    private fun initializeCars(): List<Car> {
        outputView.printCarNamesPrompt()
        val names = RepeatInputProcess.repeat { inputView.readCarNames() } as List<*>
        return names.map { Car(it as String, 0) }
    }

    private fun initializeRoundCount(): Int {
        outputView.printRoundCountPrompt()
        return RepeatInputProcess.repeat { inputView.readRoundCount() } as Int
    }

    private fun playGame(cars: List<Car>, roundCount: Int) {
        outputView.printRoundResultMessage()
        repeat(roundCount) {
            playOneRound(cars)
            outputView.printRoundResult(cars)
        }
    }

    private fun playOneRound(cars: List<Car>) {
        val generator = RandomNumberGenerator()
        for (car in cars) {
            tryMove(car, generator.generate())
        }
    }

    private fun tryMove(car: Car, number: Int) {
        if (number >= MIN_MOVE_NUMBER) car.move()
    }

    private fun finishGame(cars: List<Car>) {
        val maxCount = cars.maxOfOrNull { it.getMoveCount() }
        outputView.printWinners(cars.filter { it.getMoveCount() == maxCount }.map { it.name })
    }

    companion object {
        private const val MIN_MOVE_NUMBER = 4
    }
}
