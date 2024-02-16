package racingcar.model

class Cars(
    private val cars: List<Car>,
    private val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator(),
) {
    init {
        require(cars.distinct().size == cars.size) { NUMBER_OF_CAR_ERROR_MESSAGE }
        require(cars.size in MINIMUM_NUMBER_OF_CAR..MAXIMUM_NUMBER_OF_CAR) { DUPLICATE_CAR_NAME_ERROR_MESSAGE }
    }

    fun proceed(attempts: Int) {
        repeat(attempts) {
            val number = randomNumberGenerator.make()
            cars.forEach { car -> car.move(number) }
        }
    }

    fun winner(): List<String> {
        val winnerPosition = cars.maxOf { it.position.length }

        return cars.filter { it.position.length == winnerPosition }.map { it.name }
    }

    companion object {
        private const val MINIMUM_NUMBER_OF_CAR = 1
        private const val MAXIMUM_NUMBER_OF_CAR = 100
        private const val DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차 이름은 중복이 없어야 합니다."
        private const val NUMBER_OF_CAR_ERROR_MESSAGE = "자동차 개수는 1 ~ 100개여야 합니다."
    }
}
