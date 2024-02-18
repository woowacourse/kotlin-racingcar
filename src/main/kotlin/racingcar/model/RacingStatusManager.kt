package racingcar.model

class RacingStatusManager(
    cars: List<Car>,
    private val getNumber: () -> Int,
    private val isMovable: (Int) -> Boolean,
) {
    var currentRacingStatus: List<Car> = cars
        private set

    fun setRacingResult() {
        currentRacingStatus = currentRacingStatus.map {
            it.takeIf { isMovable(getNumber()) }?.getMoveStepResult() ?: it
        }
    }
}
