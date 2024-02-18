package racingcar.model

class RacingStatusManager(
    cars: List<Car>,
) {
    var currentRacingStatus: List<Car> = cars
        private set

    fun setRacingResult(
        getNumber: () -> Int,
        isMovable: (Int) -> Boolean
    ) {
        currentRacingStatus = currentRacingStatus.map {
            it.takeIf { isMovable(getNumber()) }?.getMoveStepResult() ?: it
        }
    }
}
