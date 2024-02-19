class RaceCarGameController {

    private fun startRace(cars: RaceCars, trialCount: Int) {
        OutputView.outputRaceResultTitle()
        repeat(trialCount) {
            cars.moveOrStop()
            OutputView.outputCarStatus(cars.toString())
        }
    }

    fun findWinners(cars: RaceCars, trialCount: Int) {
        startRace(cars, trialCount)
        val winners = cars.findWinnerCars()
        OutputView.outputWinners(winners.formatToWinners())
    }

    private fun List<RaceCar>.formatToWinners() = "최종 우승자: ${joinToString { it.name }}"
}
