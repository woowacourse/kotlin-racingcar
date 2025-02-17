package racingCar.controller

import racingCar.controller.validation.AttemptCountValidation
import racingCar.controller.validation.CarsNameValidation
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

    private fun getAttemptCount(): Int {
        val attemptCount = userInterface.handleAttemptCountMessage()
        AttemptCountValidation(attemptCount)
        return attemptCount.toInt()
    }

    private fun playRacing(
        cars: Cars,
        attemptCount: Int,
    ) {
        userInterface.handleStartRoundMessage()
        repeat(attemptCount) {
            cars.playOneRound()
            userInterface.handleRoundResultMessage(cars)
        }
    }

    private fun showWinners(cars: Cars) {
        val winners = cars.getWinner()
        userInterface.handleWinnerMessage(winners)
    }
}
