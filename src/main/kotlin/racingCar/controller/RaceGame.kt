package racingCar.controller

import racingCar.model.Car
import racingCar.model.RaceRule
import racingCar.model.RandomGenerator
import racingCar.view.InputView
import racingCar.view.OutputView

class RaceGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val randomGenerator: RandomGenerator,
    private val raceRule: RaceRule,
) {
    fun run() {
        val raceCars = getRaceCars()
        val raceCount = getRaceCount()
        start(raceCount, raceCars)
        getRaceWinners(raceCars)
    }

    private fun getRaceCars(): List<Car> {
        outputView.printRaceCarNamesGuide()

        return try {
            inputView.readRaceCars().map { carName -> Car(carName) }
        } catch (error: IllegalArgumentException) {
            outputView.printErrorMessage(message = error.message ?: "")
            return getRaceCars()
        }
    }

    private fun getRaceCount(): Int {
        outputView.printRaceCountGuide()
        return try {
            inputView.readRaceCount()
        } catch (error: IllegalArgumentException) {
            outputView.printErrorMessage(message = error.message ?: "")
            return getRaceCount()
        }
    }

    private fun start(
        raceCount: Int,
        raceCars: List<Car>,
    ) {
        outputView.printRaceResultTitle()
        repeat(raceCount) {
            progress(raceCars)
        }
    }

    private fun progress(raceCars: List<Car>) {
        raceCars.forEach { raceCar ->
            val randomNumber = randomGenerator.getRandomNumber()
            val isMoved = raceRule.isCarAbleToMove(randomNumber)
            if (isMoved) raceCar.moveForward()
            outputView.printRaceProgress(raceCar.name, raceCar.position)
        }
        outputView.printLineBreak()
    }

    private fun getRaceWinners(raceCars: List<Car>) {
        val winnerNames = raceRule.selectWinnerNames(raceCars)
        outputView.printWinners(winnerNames)
    }
}
