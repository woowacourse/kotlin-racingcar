package racingcar.domain

class RacingManager() {
    private lateinit var cars: List<Car>
    private var racingCount = 0

    fun setGame(carNames: List<String>, racingCount: Int) {
        this.cars = carNames.map { Car(it) }
        this.racingCount = racingCount
    }
}
