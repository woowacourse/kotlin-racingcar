package racingcar.domain

private const val DUPLICATE_CAR_NAME_EXIST_ERROR_MESSAGE = "중복된 차 이름이 존재합니다."
private const val NULL_ERROR_MESSAGE = "널값을 입력할 수 없습니다."
private const val START_RANDOM_NUMBER = 0
private const val END_RANDOM_NUMBER = 9

class Cars(private val cars: List<Car>) {
    init {
        validateCarNames(cars.map { car -> car.name }.toList())
    }

    private fun validateCarNames(names: List<String>?) {
        require(names != null) { NULL_ERROR_MESSAGE }
        require(!isDuplicateNames(names)) { DUPLICATE_CAR_NAME_EXIST_ERROR_MESSAGE }
    }

    private fun isDuplicateNames(names: List<String>): Boolean {
        return HashSet(names).size != names.size
    }

    fun proceed() {
        cars.forEach { car -> car.proceed((START_RANDOM_NUMBER..END_RANDOM_NUMBER).random()) }
    }

    fun findWinners(): List<Car> {
        return cars
            .filter { car -> car.position == findMaxPosition() }
            .toList()
    }

    private fun findMaxPosition(): Int {
        return cars
            .maxOf { car -> car.position }
    }

    fun getCars(): List<Car> {
        return cars
    }
}
