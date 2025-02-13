class Organizer(
    private val inputReader: InputReader,
    private val outputPrinter: OutputPrinter,
    private val judge: Judge,
) {
    fun hostRace() {
        val raceCars = getRaceCars()
        val raceCount = getRaceCount()
        executeRaces(raceCount, raceCars)
        getRaceWinners(raceCars)
    }

    private fun getRaceCars(): List<Car> {
        outputPrinter.printRaceCarNamesGuide()
        return inputReader.readRaceCars()
    }

    private fun getRaceCount(): Int {
        outputPrinter.printRaceCountGuide()
        return inputReader.readRaceCount()
    }

    private fun executeRaces(
        raceCount: Int,
        raceCars: List<Car>,
    ) {
        val randomGenerator = RandomGenerator()
        outputPrinter.printRaceResultTitle()
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
        outputPrinter.printRaceProgress(raceCars)
    }

    private fun getRaceWinners(raceCars: List<Car>) {
        val winnerNames = judge.selectWinnerNames(raceCars)
        outputPrinter.printWinners(winnerNames)
    }
}
