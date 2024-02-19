fun main() {
    val raceCars = generateRaceCars()
    val trialCount = InputView.inputTrialCount()
    RaceCarGameController().findWinners(raceCars, trialCount)
}

fun generateRaceCars(): RaceCars {
    val carNames = InputView.inputCarNames()
    return RaceCars.from(carNames) { (0..10).random() }
}
