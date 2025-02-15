class CarFactory {
    private val anonymousNumbers = mutableSetOf<Int>()

    fun createCars(
        carsName: List<String>,
        anonymousTryMoveNumberGenerator: AnonymousNumberStrategy = AnonymousNumberGenerator(),
    ): List<Car> {
        val cars = mutableListOf<Car>()
        anonymousNumbers.addAll(initAnonymousNumbers(carsName))
        carsName.forEach { carName -> cars.add(createCar(carName, anonymousTryMoveNumberGenerator)) }
        return cars.distinct()
    }

    private fun initAnonymousNumbers(carsName: List<String>): List<Int> {
        return carsName.filter { carName -> carName.startsWith(ANONYMITY) }
            .mapNotNull { anonymousName -> anonymousName.removePrefix(ANONYMITY).toIntOrNull() }
    }

    private fun createCar(
        name: String,
        anonymousTryMoveNumberGenerator: AnonymousNumberStrategy = AnonymousNumberGenerator(),
    ): Car {
        if (name.isBlank()) {
            val anonymousNumber = anonymousTryMoveNumberGenerator.getNumber(anonymousNumbers)
            anonymousNumbers.add(anonymousNumber)
            return Car(ANONYMITY + anonymousNumber)
        }
        return Car(name)
    }

    companion object {
        private const val ADD_DUPLICATE_COUNT = 1
        private const val ANONYMITY = "익명"
    }
}
