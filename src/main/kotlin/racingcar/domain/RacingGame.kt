package racingcar.domain

class RacingGame {
    private val cars: MutableList<Car> = mutableListOf()

    fun initializeCars(carNames: List<String>) {
        carNames.forEach { cars.add(Car(it)) }
    }
}
