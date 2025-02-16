class CarFactory(private val anonymousNumberStrategy: AnonymousNumberStrategy = AnonymousNumberGenerator()) {
    private val anonymousNumbers = mutableSetOf<Int>()

    fun createCars(carsName: List<String>): List<Car> {
        val cars = mutableListOf<Car>()
        anonymousNumbers.addAll(initAnonymousNumbers(carsName))
        carsName.forEach { carName -> cars.add(createCar(carName)) }
        anonymousNumbers.clear()
        return cars.distinct()
    }

    private fun initAnonymousNumbers(carsName: List<String>): List<Int> {
        return carsName.filter { carName -> carName.startsWith(ANONYMITY) }
            .mapNotNull { anonymousName -> anonymousName.removePrefix(ANONYMITY).toOnlyIntOrNull() }
    }

    private fun createCar(name: String): Car {
        if (name.isBlank()) {
            val anonymousNumber = anonymousNumberStrategy.getNumber(anonymousNumbers)
            anonymousNumbers.add(anonymousNumber)
            return Car(ANONYMITY + anonymousNumber)
        }
        return Car(name)
    }

    companion object {
        private const val ANONYMITY = "익명"
    }
}
