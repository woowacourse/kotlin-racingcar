package domain

class Cars(names: List<String>) {

    val value: List<Car>

    init {
        value = names.map { Car(it) }
    }

    fun moveAll() {
        for (car in value) {
            car.move()
        }
    }
}