package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.ui.InputReader
import racingcar.ui.OutputPrinter
import racingcar.util.RandomGenerator

class RaceController(
    private val inputReader: InputReader,
    private val outputPrinter: OutputPrinter,
) {
    fun hostRace() {
        val randomGenerator = RandomGenerator()
        val raceCars = Cars(getRaceCars(), randomGenerator)
        val raceCount = getRaceCount()

        executeRaces(raceCount, raceCars)
        getRaceWinners(raceCars)
    }

    private fun getRaceCars(): List<Car> {
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
        raceCars.moveCars()
        outputPrinter.printRaceProgress(raceCars.cars)
    }

    private fun getRaceWinners(raceCars: Cars) {
        val winnerNames = raceCars.getWinnerNames()
        outputPrinter.printWinners(winnerNames)
    }
}
