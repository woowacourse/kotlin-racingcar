class World {
    val cars = mutableListOf<Car>()
    var attemptCount = 0
    fun init() {

    }

    fun run() {
        for (i in 0 until cars.size) {

        }
    }

    fun determineWinner() {

    }

    fun processStep(car : Car) {
        val number = generateRandom()
        if (number >= 4){
            car.forward()
        }
    }

    fun generateRandom(): Int {

    }
}