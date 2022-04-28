package domain

class RacingGame(carNames: List<String>, private val totalRounds: Int, private val moveStrategy: MoveStrategy) {

    private val cars: Cars
    private var currentRound = 0;

    init {
        if (totalRounds <= 0) {
            throw IllegalArgumentException("양수를 입력해야 합니다.")
        }
        this.cars = Cars(carNames)
    }

    fun playRound() {
        cars.race(moveStrategy)
        currentRound++
    }

    fun isOver(): Boolean {
        return currentRound >= totalRounds
    }

    fun getCars(): List<Car> {
        return cars.cars
    }

    fun getWinners(): List<Car> {
        return cars.findWinners()
    }
}