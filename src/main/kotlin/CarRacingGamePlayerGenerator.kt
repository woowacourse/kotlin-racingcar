class CarRacingGamePlayerGenerator {

    fun generateCarRacers(cars: List<Car>, numberOfTry: Int) = cars.map { car ->
        CarRacingGamePlayer(car, numberOfTry)
    }
}
