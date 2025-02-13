class Organizer {
    private val inputReader = InputReader()
    private val outputPrinter = OutputPrinter()
    private val randomGenerator = RandomGenerator()
    private val judge = Judge()

    fun prepare() {
        outputPrinter.printRaceCarNamesGuide()
        val cars = inputReader.readCarNames() // TODO: car 객체를 반환하는데 메서드 네이밍은 readCarNames임 그래서 수정하기
        outputPrinter.printRaceCountGuide()
        val raceCount = inputReader.readRaceCount()
        outputPrinter.printRaceResultTitle()
        repeat(raceCount) {
            startRace(cars)
        }
        val winnerNames = judge.selectWinners(cars)
        outputPrinter.printWinners(winnerNames)
    }

    private fun startRace(cars: List<Car>) {
        cars.forEach { car ->
            runCar(car)
        }
        outputPrinter.printRaceProgress(cars)
    }

    private fun runCar(car: Car) {
        val isMoved = randomGenerator.getRandomAvailability()
        if (isMoved) car.moveForward()
    }
}
