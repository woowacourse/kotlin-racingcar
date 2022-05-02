package racingcar.domain

class Cars(carNames: List<String>) {

    val cars: List<Car>

    init {
        require(carNames.size == carNames.distinct().size) { "중복된 이름을 입력하면 안됩니다." }
        this.cars = carNames.map { Car(it) }
    }

    fun race(moveStrategy: MoveStrategy) {
        for (car in cars) {
            car.goOrNot(moveStrategy)
        }
    }

    fun findWinners(): List<Car> {
        val carMaxPosition = cars.maxOrNull() ?: throw IllegalArgumentException("Car 리스트가 비었습니다.")
        return cars.filter { it.isSamePosition(carMaxPosition) }
    }
}
