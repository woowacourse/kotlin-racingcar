class Car private constructor(
    val name: String,
    position: Int = INITIAL_CAR_POSITION,
) {
    var position: Int = position
        private set

    fun moveForward(isMoved: Boolean) {
        if (isMoved) position++
    }

    companion object {
        private const val INITIAL_CAR_POSITION = 0
        private const val MIN_CAR_NAME_LENGTH = 1
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val MIN_RANDOM_AVAILABILITY_CONDITION = 4

        operator fun invoke(
            name: String,
            position: Int = INITIAL_CAR_POSITION,
        ): Car {
            validateCarName(name)
            return Car(name, position)
        }

        private fun validateCarName(carName: String) {
            require(carName.isNotBlank()) { "[ERROR] 자동차 이름은 공백일 수 없습니다. (입력한 이름: $carName)" }
            require(carName.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) {
                "[ERROR] 자동차 이름은 ${MIN_CAR_NAME_LENGTH}자 이상 ${MAX_CAR_NAME_LENGTH}자 이하여야 합니다. (입력한 이름: $carName)"
            }
        }

        fun isCarAbleToMove(randomNumber: Int): Boolean = randomNumber >= MIN_RANDOM_AVAILABILITY_CONDITION

        fun getWinnerNames(raceCars: List<Car>): List<String> {
            val maxPosition = raceCars.maxOf { raceCar -> raceCar.position }
            return raceCars.toWinnerCars(maxPosition).toCarNames()
        }

        private fun List<Car>.toWinnerCars(maxPosition: Int) = this
            .filter { raceCar ->
                raceCar.position == maxPosition
            }

        private fun List<Car>.toCarNames() = this.map { car -> car.name }
    }
}
