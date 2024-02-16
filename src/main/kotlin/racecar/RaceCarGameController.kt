import kotlin.random.Random

class RaceCarGameController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    private lateinit var cars: RaceCars
    private var trialCount: Int = 0

    fun run() {
        initRaceCars()
        initTrialCount()
        startRaceGame()
    }

    private fun initRaceCars() {
        outputView.outputCarNamesRequest()
        cars =
            RaceCars.from(
                carNames = inputView.inputCarNames(),
                numberGenerator = { Random.nextInt(10) },
            )
    }

    private fun initTrialCount() {
        outputView.outputTrialCountRequest()
        trialCount = inputView.inputTrialCount()
    }

    private fun startRaceGame() {
        val winners =
            cars.run {
                startRace()
                findHeadGroup()
            }
        outputView.outputWinners(winners.formatToWinners())
    }

    private fun RaceCars.startRace() {
        outputView.outputRaceResultTitle()
        repeat(trialCount) {
            move()
            outputView.outputCarStatus(toString())
        }
    }

    private fun List<RaceCar>.formatToWinners() = "최종 우승자: ${joinToString { it.name }}"
}
