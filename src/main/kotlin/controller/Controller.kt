package controller

import domain.Car
import domain.RandomNumberGenerator
import domain.Referee
import view.InputView
import view.OutputView

class Controller(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val generator: RandomNumberGenerator
) {
    fun start() {
        val cars = initializeCars()
        playGame(cars, initializeRoundCount())
        finishGame(cars)
    }

    private fun initializeCars(): List<Car> {
        outputView.printCarNamesPrompt()
        return runCatching {
            val carNames = inputView.readCarNames()
            carNames.map { Car(it) }
        }.getOrElse { error ->
            println(error.message.toString())
            initializeCars()
        }
    }

    private fun initializeRoundCount(): Int {
        outputView.printRoundCountPrompt()
        return runCatching {
            inputView.readRoundCount()
        }.getOrElse { error ->
            println(error.message.toString())
            initializeRoundCount()
        }
    }

    private fun playGame(cars: List<Car>, roundCount: Int) {
        outputView.printRoundResultMessage()
        repeat(roundCount) {
            playOneRound(cars)
            outputView.printRoundResult(cars)
        }
    }

    private fun playOneRound(cars: List<Car>) {
        cars.forEach { car ->
            car.tryMove(generator.generate())
        }
    }

    private fun finishGame(cars: List<Car>) {
        val winners = Referee.judgeWinners(cars)
        outputView.printWinners(winners)
    }
}
