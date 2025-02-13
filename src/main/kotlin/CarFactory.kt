class CarFactory {
    fun createCar(carNames: List<String>): List<Car> {
        val anonymousCounts = (1..carNames.count { it.isBlank() }).toMutableList()
        return carNames.map { carName -> getAnonymousCar(carName, anonymousCounts) }
    }

    private fun getAnonymousCar(
        name: String,
        anonymousCounts: MutableList<Int>,
    ): Car {
        if (name.isBlank()) return Car("익명${anonymousCounts.removeFirst()}")
        return Car(name)
    }
}
