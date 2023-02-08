package racing.model

class RacingGame {
    private val cars = mutableListOf<Car>()

    fun getCars() = cars.toList()

    fun racingStart(cars: List<Car>, maxMoveCount: Int) {
        this.cars.addAll(cars)
        move(cars)
    }

    fun getWinners(): List<String> {
        cars.sortBy { it.getPosition() }
        val result = mutableListOf<String>()
        for (car in cars) {
            if (car.getPosition() == cars.last().getPosition()) result.add(car.getName())
        }
        return result.toList()
    }

    private fun move(cars: List<Car>) {
        for (car in cars) {
            car.move()
        }
    }
}
