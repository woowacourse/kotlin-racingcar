package model

class CarFactory {
    fun createCars(carNames: List<String>): List<Car> { // 🚀 List<String>을 받도록 변경
        require(carNames.size > MIN_CAR_NUM) { INVALID_CAR_SIZE_MESSAGE }
        require(carNames.toSet().size == carNames.size) { DUPLICATE_CAR_NAME_MESSAGE }

        return carNames.map { Car(it.trim()) }
    }

    private companion object {
        const val INVALID_CAR_SIZE_MESSAGE: String = "레이싱 게임은 두대 이상이어야 합니다."
        const val DUPLICATE_CAR_NAME_MESSAGE: String = "자동차 이름이 중복됩니다."
        const val MIN_CAR_NUM: Int = 1
    }
}
