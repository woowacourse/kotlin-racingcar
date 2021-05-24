package racingcar.model

class RacingCarGame(var cars: Cars, private val tryNumber: Int) {

    fun race(moveStrategy: MoveStrategy): Pair<List<Cars>, List<Car>> {
        val carsGroup = mutableListOf<Cars>()
        repeat(tryNumber) {
            cars = cars.moveAll(moveStrategy)
            carsGroup.add(this.cars)
        }
        return Pair(carsGroup, findWinners())
    }

    private fun findWinners(): List<Car> {
        val maxPosition = cars.findMaxPosition()
        return cars.findCarsBySamePosition(maxPosition)
    }
}
