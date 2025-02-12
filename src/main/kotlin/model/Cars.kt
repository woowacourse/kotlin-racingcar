package model

class Cars(private val input: String) {
    lateinit var parsedCars: List<Car>

    init {
        validateCars()
        parseCars()
    }

    private fun validateCars() {
        require(input.isNotEmpty()) { "자동차 이름을 입력해주세요." }
        val cars = input.split(",")
        require(cars.toSet().size == cars.size) { "자동차 이름 중 중복이 존재합니다." }
        require(cars.size > 1) { "자동차가 2대 이상일 때 경주가 가능합니다." }
    }

    private fun parseCars() {
        parsedCars = input.split(",").map { Car(it) }
    }
}
