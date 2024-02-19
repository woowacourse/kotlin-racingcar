package racingcar.domain

class RacingGame(carNames: List<String>) {
    val cars: List<Car> = carNames.map { Car(it) }

    fun playOneRound() {
        cars.forEach {
            it.move()
        }
    }
}
