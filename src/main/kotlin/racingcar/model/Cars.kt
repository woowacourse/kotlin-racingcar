package racingcar.model

class Cars(
    val cars: List<Car>,
    names: List<String> = cars.map { car -> car.name },
) {
    init {
        validateApplicantCars(names)
    }

    private fun validateApplicantCars(carNames: List<String>) {
        require(carNames.size == carNames.toSet().size) {
            "[ERROR] 자동차 이름은 중복될 수 없습니다. (입력한 이름: ${
                carNames.joinToString(
                    ", "
                )
            })"
        }
        require(carNames.size >= MIN_RACE_CAR_COUNT) { "[ERROR] 자동차가 ${MIN_RACE_CAR_COUNT}대 이상일 경우에만 경기가 시작됩니다. (입력한 참가자 수: ${carNames.size} 대)" }
    }

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

    companion object {
        private const val MIN_RACE_CAR_COUNT = 2
    }
}
