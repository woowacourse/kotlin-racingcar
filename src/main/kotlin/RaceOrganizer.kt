class RaceOrganizer(
    private val inputReader: InputReader,
    private val outputPrinter: OutputPrinter,
) {
    fun hostRace() {
        val raceCars = getRaceCars()
        val raceCount = getRaceCount()
        val randomGenerator = RandomGenerator()

        executeRaces(raceCount, raceCars, randomGenerator)
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
        randomGenerator: RandomGenerator,
    ) {
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
            val isMoved = Car.isCarAbleToMove(randomNumber)
            raceCar.moveForward(isMoved)
        }
        outputPrinter.printRaceProgress(raceCars)
    }

    private fun getRaceWinners(raceCars: List<Car>) {
        val winnerNames = Car.getWinnerNames(raceCars)
        outputPrinter.printWinners(winnerNames)
    }
}
