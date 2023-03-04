package domain

class Cars(names: List<String>) {

    private val value: List<Car>

    init {
        value = names.map { Car(it) }
    }

    fun moveAll() {
        for (car in value) {
            car.move();
        }
    }
}