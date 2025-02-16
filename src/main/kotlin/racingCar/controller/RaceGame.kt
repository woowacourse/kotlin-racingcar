package racingCar.controller

import racingCar.model.Car
import racingCar.model.RandomGenerator
import racingCar.model.Referee
import racingCar.view.InputView
import racingCar.view.OutputView

class RaceGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val referee: Referee,
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
        val randomGenerator = RandomGenerator()
        outputView.printRaceResultTitle()
        repeat(raceCount) {
            progress(raceCars, randomGenerator)
        }
    }

    private fun progress(
        raceCars: List<Car>,
        randomGenerator: RandomGenerator,
    ) {
        raceCars.forEach { raceCar ->
            val randomNumber = randomGenerator.getRandomNumber()
            val isMoved = referee.isCarAbleToMove(randomNumber)
            if (isMoved) raceCar.moveForward()
            outputView.printRaceProgress(raceCar.name, raceCar.position)
        }
        outputView.printLineBreak()
    }

    private fun getRaceWinners(raceCars: List<Car>) {
        val winnerNames = referee.selectWinnerNames(raceCars)
        outputView.printWinners(winnerNames)
    }
}
