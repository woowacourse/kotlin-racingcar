package racingCar

class Organizer(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val judge: Judge,
) {
    fun hostRace() {
        val raceCars = getRaceCars()
        val raceCount = getRaceCount()
        executeRaces(raceCount, raceCars)
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

    private fun executeRaces(
        raceCount: Int,
        raceCars: List<Car>,
    ) {
        val randomGenerator = RandomGenerator()
        outputView.printRaceResultTitle()
        repeat(raceCount) {
            executeRace(raceCars, randomGenerator)
        }
    }

    private fun executeRace(
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
