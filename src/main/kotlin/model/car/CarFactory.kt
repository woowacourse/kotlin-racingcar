package model.car

class CarFactory {
    fun createCar(carNames: List<String>): List<Car> {
        val anonymousCounts = (ANONYMITY_MIN_COUNT..carNames.count { it.isBlank() }).toMutableList()
        return carNames.map { carName -> getAnonymousCar(carName, anonymousCounts) }
    }

    private fun getAnonymousCar(
        name: String,
        anonymousCounts: MutableList<Int>,
    ): Car {
        if (name.isBlank()) return Car(ANONYMITY + anonymousCounts.removeFirst())
        return Car(name)
    }

    companion object {
        const val ANONYMITY_MIN_COUNT = 1
        const val ANONYMITY = "익명"
    }
}
