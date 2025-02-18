package racingcar.controller

import racingcar.model.Cars
import racingcar.model.Race
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

        startRace(raceCount, raceCars)
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

    private fun startRace(
        raceCount: Int,
        raceCars: Cars,
    ) {
        val race = Race(raceCars, raceCount, randomGenerator)

        outputPrinter.printRaceResultTitle()

        while (race.isNotEnd()) {
            race.proceed()
            outputPrinter.printRaceProgress(race.raceCars.cars)
        }
    }

    private fun getRaceWinners(raceCars: Cars) {
        val winnerNames = raceCars.getWinnerNames()
        outputPrinter.printWinners(winnerNames)
    }
}
