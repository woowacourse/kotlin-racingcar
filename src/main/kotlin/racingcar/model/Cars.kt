package racingcar.model

import racingcar.controller.Race

class Cars(
    private val names: List<String>,
) {
    init {
        require(names.isNotEmpty()) { Race.ERROR_REQUEST_INPUT }
        require(names.size >= MIN_NAMES_SIZE) { ERROR_CAR_LESS_THAN_TWO }
        require(names.size <= MAX_NAMES_SIZE) { ERROR_CAR_GREATER_THAN_TWENTY }
        require(names.distinct().size == names.size) { ERROR_NAME_DUPLICATION }
    }

    fun makeCars(): List<Car> {
        val cars = mutableListOf<Car>()

        names.forEach { name ->
            cars.add(Car(name))
        }
        return cars
    }

    companion object {
        const val ERROR_CAR_LESS_THAN_TWO = "[Error] 자동차 이름은 2대 이상 입력해 주세요."
        const val ERROR_CAR_GREATER_THAN_TWENTY = "[Error] 자동차 이름은 20대 이하로 입력해 주세요."
        const val ERROR_NAME_DUPLICATION = "[Error] 중복된 자동차 이름은 작성할 수 없습니다."

        const val MIN_NAMES_SIZE = 2
        const val MAX_NAMES_SIZE = 20
    }
}