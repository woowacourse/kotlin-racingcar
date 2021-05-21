package racingcar.model

class RacingCarGame(var cars: Cars, val tryNumber: Int) {

    fun race(moveStrategy: MoveStrategy): List<Cars> {
        val carsGroup = arrayListOf<Cars>()
        for (i in 0 until tryNumber) {
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
