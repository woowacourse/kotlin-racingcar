class CarGenerator {

    fun generateCars(names: List<String>) = names.map { name ->
        Car(0, name)
    }
}
