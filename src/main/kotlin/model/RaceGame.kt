package model

class RaceGame(
    private val count: Int,
    private val cars: List<Car>,
) {
    fun fullRace(): List<List<Car>> {
        val raceResults = mutableListOf<List<Car>>()
        repeat(count) {
            oneRace()
            raceResults.add(cars.map { Car(it.name, it.currentPosition) })
        }
        return raceResults
    }

    private fun oneRace() {
        for (car in cars) {
            car.moveCar()
        }
    }

    fun getFinalResult(): MutableList<Car> {
        return comparePosition()
    }

    private fun comparePosition(): MutableList<Car> {
        val maxPosition = cars.maxOfOrNull { it.currentPosition }
        val winnerList = cars.filter { it.currentPosition == maxPosition }.toMutableList()
        return winnerList
    }
}
