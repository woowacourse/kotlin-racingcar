package racingcar.model

import racingcar.controller.RacingController

class RacingStatusManager(
    cars: List<Car>,
    private val getNumber: () -> Int,
    private val isMovable: (Int) -> Boolean,
) {
    var currentRacingStatus: List<Car> = cars
        private set

    fun getRacingStatus(): List<Car> {
        currentRacingStatus.forEach {
            if (isMovable(getNumber())) it.moveStep()
        }

        return currentRacingStatus
    }

    fun getWinners(): List<String> {
        val maxPosition = currentRacingStatus.maxBy { it.position }.position
        return currentRacingStatus.filter { it.position == maxPosition }.map { it.name }
    }
}
