import kotlin.random.Random

class RaceCarGameController {
    private lateinit var cars: RaceCars
    private var trialCount: Int = 0

    fun run() {
        initRaceCars()
        initTrialCount()
        startRaceGame()
    }

    private fun initRaceCars() {
        OutputView.outputCarNamesRequest()
        cars =
            RaceCars.from(
                carNames = InputView.inputCarNames(),
                numberGenerator = { Random.nextInt(10) },
            )
    }

    private fun initTrialCount() {
        OutputView.outputTrialCountRequest()
        trialCount = InputView.inputTrialCount()
    }

    private fun startRaceGame() {
        val winners =
            cars.run {
                startRace()
                findHeadGroup()
            }
        OutputView.outputWinners(winners.formatToWinners())
    }

    private fun RaceCars.startRace() {
        OutputView.outputRaceResultTitle()
        repeat(trialCount) {
            moveOrStop()
            OutputView.outputCarStatus(toString())
        }
    }

    private fun List<RaceCar>.formatToWinners() = "최종 우승자: ${joinToString { it.name }}"
}
