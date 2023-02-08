class CarRacerGenerator {

    fun generateCarRacers(cars: List<Car>, numberOfTry: Int) = cars.map { car ->
        CarRacer(car, numberOfTry)
    }
}
