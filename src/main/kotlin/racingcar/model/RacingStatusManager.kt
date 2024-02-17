package racingcar.model

class RacingStatusManager(cars: List<Car>) {
    private val movementDecisionMaker = MovementDecisionMaker()
    private val numberGenerator = RandomNumberGenerator()

    var currentRacingStatus: List<Car> = cars
        private set

    fun setRacingResult() {
        currentRacingStatus = currentRacingStatus.map {
            it.takeIf { movementDecisionMaker.isMovable(numberGenerator.getRandomNumber()) }?.getMoveStepResult() ?: it
        }
    }
}
