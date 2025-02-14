package racingCar

class RaceGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val judge: Judge,
) {
    fun run() {
        val raceCars = getRaceCars()
        val raceCount = getRaceCount()
        start(raceCount, raceCars)
        getRaceWinners(raceCars)
    }

    private fun getRaceCars(): List<Car> {
        outputView.printRaceCarNamesGuide()
        return inputView.readRaceCars()
    }

    private fun getRaceCount(): Int {
        outputView.printRaceCountGuide()
        return inputView.readRaceCount()
    }

    private fun start(
        raceCount: Int,
        raceCars: List<Car>,
    ) {
        val randomGenerator = RandomGenerator()
        outputView.printRaceResultTitle()
        repeat(raceCount) {
            progress(raceCars, randomGenerator)
        }
    }

    private fun progress(
        raceCars: List<Car>,
        randomGenerator: RandomGenerator,
    ) {
        raceCars.forEach { raceCar ->
            val randomNumber = randomGenerator.getRandomNumber()
            val isMoved = judge.isCarAbleToMove(randomNumber)
            raceCar.moveForward(isMoved)
        }
        outputView.printRaceProgress(raceCars)
    }

    private fun getRaceWinners(raceCars: List<Car>) {
        val winnerNames = judge.selectWinnerNames(raceCars)
        outputView.printWinners(winnerNames)
    }
}
