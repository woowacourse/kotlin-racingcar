package racingcar

import racingcar.domain.Configure.Companion.RANDOM_SEED
import racingcar.view.InputView
import racingcar.view.OutputView
import kotlin.random.Random

fun main() {
    Application().run()
}

class Application {
    private val random = Random(RANDOM_SEED)
    private val outputView = OutputView()
    private val inputView = InputView()
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
