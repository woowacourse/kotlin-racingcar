import kotlin.random.Random

class RaceCarGameController {

    private val cars: RaceCars by lazy {
        RaceCars.from(
            carNames = InputView.inputCarNames(),
            numberGenerator = { Random.nextInt(10) },
        )
    }
    private val trialCount: Int by lazy {
        InputView.inputTrialCount()
    }
    private val winners: List<RaceCar> by lazy {
        cars.run {
            startRace()
            findHeadGroup()
        }
    }

    fun run() {
        initRaceCars()
        initTrialCount()
        getWinners()
    }

    private fun initRaceCars() {
        OutputView.outputCarNamesRequest()
        cars
    }

    private fun initTrialCount() {
        OutputView.outputTrialCountRequest()
        trialCount
    }

    private fun getWinners() = OutputView.outputWinners(winners.formatToWinners())

    private fun RaceCars.startRace() {
        OutputView.outputRaceResultTitle()
        repeat(trialCount) {
            moveOrStop()
            OutputView.outputCarStatus(toString())
        }
    }

    private fun List<RaceCar>.formatToWinners() = "최종 우승자: ${joinToString { it.name }}"
}
