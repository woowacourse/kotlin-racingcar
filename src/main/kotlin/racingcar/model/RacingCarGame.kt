package racingcar.model

class RacingCarGame(cars: Cars, private val tryNumber: Int) {
    var cars: Cars = cars
    private set

    fun race(moveStrategy: MoveStrategy): List<Cars> {
        val carsGroup = mutableListOf<Cars>()
        repeat(tryNumber) {
            this.cars = this.cars.moveAll(moveStrategy)
            carsGroup.add(this.cars)
        }
        return carsGroup
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.findMaxPosition()
        return cars.findCarsBySamePosition(maxPosition)
    }
}
