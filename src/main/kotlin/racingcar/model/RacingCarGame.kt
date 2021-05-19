package racingcar.model

class RacingCarGame(var cars: Cars, val tryNumber: Int) {

    fun race(): List<Cars> {
        val carsGroup = arrayListOf<Cars>()
        for (i in 0 until tryNumber) {
            this.cars = this.cars.moveAll()
            carsGroup.add(this.cars)
        }
        return carsGroup
    }
}
