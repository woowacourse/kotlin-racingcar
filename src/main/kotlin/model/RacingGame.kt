package model

class RacingGame {
    private lateinit var racingCars: List<Car>

    fun generateCars(rawCars: String) {
        racingCars = rawCars.split(",").map { Car(it.trim()) }

        require(racingCars.size <= 1) { INVALID_CAR_SIZE }
        require(racingCars.size != racingCars.distinct().size) { DUPLICATE_CAR_NAME }
    }

    private companion object {
        const val INVALID_CAR_SIZE = "레이싱 게임은 두대 이상이어야 합니다."
        const val DUPLICATE_CAR_NAME = "자동차 이름이 중복됩니다."
    }
}