package racingCar.domain

class Cars(val cars: List<Car>) {

    fun moveAll() {
        cars.forEach(Car::move)
    }

    fun getWinner(): List<Name> {
        val maxPosition = getMaxPosition()
        return cars.filter { it.position == maxPosition }.map { it.name }
    }

    private fun getMaxPosition(): Int {
        return cars.maxOf(Car::position)
    }
}
