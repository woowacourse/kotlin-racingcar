import kotlin.random.Random

class RaceCarGameController {
    private lateinit var cars: List<RaceCar>
    private var trialCount: Int = 0

    fun run() {
        initCars()
        initTrialCount()
        startRaceGame()
        showWinners()
    }

    private fun initCars() {
        OutputView.outputCarNamesRequest()
        cars = InputView.inputCarNames().map { RaceCar(it) }
    }

    private fun initTrialCount() {
        OutputView.outputTrialCountRequest()
        trialCount = InputView.inputTrialCount()
    }

    private fun startRaceGame() {
        val raceCarGame = RaceCarGame(cars, numberGenerator = { Random.nextInt(10) })
        OutputView.outputRaceResultTitle()
        repeat(trialCount) {
            val status = raceCarGame.runOneRound()
            OutputView.outputCarStatus(status.formatToStatus())
        }
    }

    private fun showWinners() {
        val winners = cars.findWinners()
        OutputView.outputWinners(winners.formatToWinners())
    }

    private fun List<RaceCar>.findWinners(): List<RaceCar> {
        val winnerCar = maxOf { it }
        val winnerCars = filter { it.compareTo(winnerCar) == 0 }
        return winnerCars
    }

    private fun List<RaceCar>.formatToStatus(): String {
        val sb = StringBuilder()
        forEach {
            sb.append("$it\n")
        }
        return sb.toString()
    }

    private fun List<RaceCar>.formatToWinners() = "최종 우승자: ${joinToString { it.name }}"
}