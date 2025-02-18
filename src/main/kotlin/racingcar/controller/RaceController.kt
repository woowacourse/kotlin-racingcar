package racingcar.controller

import racingcar.model.Cars
import racingcar.model.Race
import racingcar.util.RandomGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val randomGenerator: RandomGenerator,
) {
    fun hostRace() {
        val raceCars = getRaceCars()
        val raceCount = getRaceCount()

        startRace(raceCount, raceCars)
        getRaceWinners(raceCars)
    }

    private fun getRaceCars(): Cars {
        outputView.printRaceCarNamesGuide()
        return inputView.readRaceCars()
    }

    private fun getRaceCount(): Int {
        outputView.printRaceCountGuide()
        return inputView.readRaceCount()
    }

    private fun startRace(
        raceCount: Int,
        raceCars: Cars,
    ) {
        val race = Race(raceCars, raceCount, randomGenerator)

        outputView.printRaceResultTitle()

        while (race.isNotEnd()) {
            race.proceed()
            outputView.printRaceProgress(race.raceCars.cars)
        }
    }

    private fun getRaceWinners(raceCars: Cars) {
        val winnerNames = raceCars.getWinnerNames()
        outputView.printWinners(winnerNames)
    }
}
