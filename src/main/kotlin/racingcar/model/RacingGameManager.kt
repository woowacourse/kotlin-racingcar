package racingcar.model

class RacingGameManager {
    private lateinit var racingStatusManager: RacingStatusManager
    private lateinit var numberGenerator: NumberGenerator
    private lateinit var movementDecisionMaker: MovementDecisionMaker

    fun initializeCars(names: List<String>) {
        val pickingStrategy = RandomNumberPickingStrategy()
        numberGenerator = NumberGenerator(pickingStrategy)
        movementDecisionMaker = ThresholdMovementDecisionMaker()
        racingStatusManager = RacingStatusManager(
            cars = names.map { Car(it) },
            getNumber = numberGenerator::getNumber,
            isMovable = movementDecisionMaker::isMovable
        )
    }

    fun play() = racingStatusManager.getRacingStatus()

    fun getWinners(): List<String> {
        val racingResult = racingStatusManager.currentRacingStatus
        val maxPosition = racingResult.maxBy { it.position }.position
        return racingResult.filter { it.position == maxPosition }.map { it.name }
    }
}
