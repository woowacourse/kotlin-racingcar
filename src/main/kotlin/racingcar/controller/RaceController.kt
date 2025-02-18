package racingcar.controller

import racingcar.model.Cars
import racingcar.util.RandomGenerator
import racingcar.view.InputReader
import racingcar.view.OutputPrinter

class RaceController(
    private val inputReader: InputReader,
    private val outputPrinter: OutputPrinter,
    private val randomGenerator: RandomGenerator,
) {
    fun hostRace() {
        val raceCars = getRaceCars()
        val raceCount = getRaceCount()

        executeRaces(raceCount, raceCars)
        getRaceWinners(raceCars)
    }

    private fun getRaceCars(): Cars {
        outputPrinter.printRaceCarNamesGuide()
        return inputReader.readRaceCars()
    }

    private fun getRaceCount(): Int {
        outputPrinter.printRaceCountGuide()
        return inputReader.readRaceCount()
    }

    private fun executeRaces(
        raceCount: Int,
        raceCars: Cars,
    ) {
        outputPrinter.printRaceResultTitle()
        repeat(raceCount) {
            executeRace(raceCars)
        }
    }

    private fun executeRace(
        raceCars: Cars,
    ) {
        val conditions = randomGenerator.getRandomConditions(raceCars.cars.size)
        raceCars.moveCars(conditions)
        outputPrinter.printRaceProgress(raceCars.cars)
    }

    private fun getRaceWinners(raceCars: Cars) {
        val winnerNames = raceCars.getWinnerNames()
        outputPrinter.printWinners(winnerNames)
    }
}
