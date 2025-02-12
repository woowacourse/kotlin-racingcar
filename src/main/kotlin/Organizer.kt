class Organizer {
    private val input = Input()
    private val output = Output()
    private val randomGenerator = RandomGenerator()
    private val judge = Judge()

    fun prepare() {
        output.printRaceCarNamesGuide()
        val cars = input.readCarNames() // TODO: car 객체를 반환하는데 메서드 네이밍은 readCarNames임 그래서 수정하기
        output.printRaceCountGuide()
        val raceCount = input.readRaceCount()
        output.printRaceResultTitle()
        repeat(raceCount) {
            startRace(cars)
        }
        val winnerNames = judge.selectWinners(cars)
        output.printWinners(winnerNames)
    }

    private fun startRace(cars: List<Car>) {
        cars.forEach { car ->
            runCar(car)
        }
        output.printRaceProgress(cars)
    }

    private fun runCar(car: Car) {
        val isMoved = randomGenerator.getRandomAvailability()
        if (isMoved) car.moveForward()
    }
}
