package model

class GenerateCar {
    fun generateCar(rawCars: String): List<Car> {
        val racingCars = rawCars.split(DELIMITER).map { Car(it.trim()) }

        require(racingCars.size > MIN_CAR_NUM) { INVALID_CAR_SIZE_MESSAGE }
        require(racingCars.map { it.name }.toSet().size == racingCars.size) { DUPLICATE_CAR_NAME_MESSAGE }

        return racingCars
    }

    private companion object {
        const val INVALID_CAR_SIZE_MESSAGE: String = "레이싱 게임은 두대 이상이어야 합니다."
        const val DUPLICATE_CAR_NAME_MESSAGE: String = "자동차 이름이 중복됩니다."
        const val MIN_CAR_NUM: Int = 1
        const val DELIMITER: String = ","
    }
}
