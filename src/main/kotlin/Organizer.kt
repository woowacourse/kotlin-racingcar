class Organizer(
    private val inputReader: InputReader,
    private val outputPrinter: OutputPrinter,
    private val judge: Judge,
) {
    fun hostRace() {
        val cars = getRaceCars()
        val raceCount = getRaceCount()
        executeRaces(raceCount, cars)
        getRaceWinners(cars)
    }

    private fun getRaceCars(): List<Car> {
        outputPrinter.printRaceCarNamesGuide()
        return inputReader.readCarNames() // TODO: car 객체를 반환하는데 메서드 네이밍은 readCarNames임 그래서 수정하기
    }

    private fun getRaceCount(): Int {
        outputPrinter.printRaceCountGuide()
        return inputReader.readRaceCount()
    }

    private fun executeRaces(
        raceCount: Int,
        cars: List<Car>,
    ) {
        outputPrinter.printRaceResultTitle()
        repeat(raceCount) {
            executeRace(cars)
        }
    }

    private fun executeRace(cars: List<Car>) {
        cars.forEach { car ->
            car.trigger()
        }
        outputPrinter.printRaceProgress(cars)
    }

    private fun getRaceWinners(cars: List<Car>) {
        val winnerNames = judge.selectWinners(cars)
        outputPrinter.printWinners(winnerNames)
    }
}
