package racingcar

import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView

fun main() {
    Application().run()
}

class Application {
    private val random = Random()
    private val outputView = ConsoleOutputView()
    private val inputView = ConsoleInputView()
    private val inputValidator = InputValidator()
    private val raceService = RaceService(random, outputView, inputView, inputValidator)

    fun run() {
        initializeRace()
        startRace()
        showRaceResult()
    }

    private fun initializeRace() {
        raceService.carsInitializer()
        raceService.raceCountInitializer()
    }

    private fun startRace() {
        raceService.showRaceResultHeader()
        raceService.doWholeRace()
    }

    private fun showRaceResult() {
        raceService.showCarNamesByWinnerFormat()
    }
}
