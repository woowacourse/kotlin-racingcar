class Cars(input: String) {
    private val cars: List<Car>
    var maxValue = -1

    init {
        this.cars = mappingCars(input)
    }

    private fun mappingCars(input: String): List<Car> = input.split(",").mapIndexed { index, name -> Car(name) }
    fun getCar(position: Int): Car = cars[position]
    fun getCarSize(): Int = cars.size

    fun move(position: Int) {
        cars[position].move(RandomGenerator().getRandomNumber())
        if (cars[position].getInfo().second > maxValue) maxValue = cars[position].getInfo().second
    }

    fun findWinners(): List<String> {
        val maxEqualCars = cars.filter {
            it.getInfo().second == maxValue
        }.toList()
        val names = mutableListOf<String>()
        for (car in maxEqualCars) {
            names.add(car.getInfo().first)
        }
        return names
    }
}
