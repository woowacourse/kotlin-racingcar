class Cars(input: String) {
    private val cars: List<Car> = input.split(Constants.CAR_NAME_DELIMITER).map { Car(it) }
    private val numberGenerator = RandomNumberGenerator()

    fun lap(){
        cars.forEach { it.moveOrStop(numberGenerator) }
    }
}