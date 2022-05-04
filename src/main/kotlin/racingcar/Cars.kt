package racingcar

class Cars private constructor(val cars: List<Car>) {

    init {
        validateCars(cars)
    }

    companion object {
        fun of(names: List<String>): Cars = Cars(names.map { Car(it) })
    }

    private fun validateCars(cars: List<Car>) {
        require(cars.isNotEmpty()) { "[ERROR] 최소 하나의 자동차를 입력하세요." }
        require(cars.size == cars.distinct().size) { "[ERROR] 중복된 이름이 존재합니다." }
    }

    fun moveAll(moveFactors: List<Int>) {
        validateMoveFactors(moveFactors)
        for (idx in moveFactors.indices) {
            cars[idx].move(moveFactors[idx])
        }
    }

    private fun validateMoveFactors(moveFactors: List<Int>) {
        require(moveFactors.size == cars.size) { "[ERROR] 이동 요소 입력을 다시해주세요." }
    }

    fun max() : Int = cars.maxOf { it.position }
}
