package racingcar.model

class Cars(
    val cars: List<Car>,
) {
    fun moveCars(conditions: List<Int>) {
        cars.zip(conditions).forEach { (raceCar, randomNumber) ->
            raceCar.moveForward(randomNumber)
        }
    }

    fun getWinnerNames(): List<String> {
        val maxPosition = cars.maxOf { raceCar -> raceCar.position }
        return cars.findWinnerCars(maxPosition).toCarNames()
    }

    private fun List<Car>.findWinnerCars(maxPosition: Int) = this
        .filter { raceCar ->
            raceCar.position == maxPosition
        }

    private fun List<Car>.toCarNames() = this.map { car -> car.name }
}
