package racecar

import kotlin.random.Random

class RaceCarGame(
    private val inputView: RaceCarGameInputView = KernelRaceCarGameInputView(),
    private val outputView: RaceCarGameOutputView = KernelRaceCarGameOutputView(),
    private val scoreGenerator: ScoreGenerator = ScoreGenerator { Random.nextInt(10) },
) {
    fun start() {
        val cars: RaceCars = initRaceCars()
        val trialCount: Int = initTrialCount()
        startRaceGame(cars, trialCount)
    }

    private fun initRaceCars() =
        RaceCars(
            carNames = inputView.inputCarNames(),
            scoreGenerator = scoreGenerator,
        )

    private fun initTrialCount(): Int = inputView.inputTrialCount()

    private fun startRaceGame(
        cars: RaceCars,
        trialCount: Int,
    ) {
        val winners =
            cars.run {
                startRace(trialCount)
                findHeadGroup()
            }
        outputView.outputWinners(winners)
    }

    private fun RaceCars.startRace(trialCount: Int) {
        outputView.outputRaceResultTitle()
        repeat(trialCount) {
            move()
            outputView.outputRacingStatus(cars)
        }
    }
}
