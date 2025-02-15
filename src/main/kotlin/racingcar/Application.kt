package racingcar

fun main() {
    Application().run()
}

class Application {
    private val raceService = RaceService()

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
