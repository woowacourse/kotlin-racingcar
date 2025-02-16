package racingCar.controller

import racingCar.controller.validation.CarsNameValidation
import racingCar.model.AttemptCount
import racingCar.model.Cars

class RacingController(
    private val userInterface: UserInteractionController = UserInteractionController(),
) {
    fun run() {
        val cars = getCars()
        val attemptCount = getAttemptCount()
        playRacing(cars, attemptCount)
        showWinners(cars)
    }

    private fun getCars(): Cars {
       val carsName = userInterface.handleStartMessage()
       CarsNameValidation(carsName)
       return Cars(carsName)
    }

    private fun getAttemptCount(): AttemptCount {
        val attemptCount = userInterface.handleAttemptCountMessage()
        AttemptCount(attemptCount)
        return AttemptCount(attemptCount)
    }

    private fun playRacing(
        cars: Cars,
        attemptCount: AttemptCount,
    ) {
        userInterface.handleStartRoundMessage()
        repeat(attemptCount.getCount()) {
            cars.playOneRound()
            userInterface.handleRoundResultMessage(cars)
        }
    }

    private fun showWinners(cars: Cars) {
        val winners = cars.getWinner()
        userInterface.handleWinnerMessage(winners)
    }
}
