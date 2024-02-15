class RaceCarGame(
    private val cars: List<RaceCar>,
    private val numberGenerator: NumberGenerator,
) {
    fun runOneRound(): List<RaceCar> {
        return cars.onEach {
            it.moveOrStop(numberGenerator.generate())
        }
    }
}