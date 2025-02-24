package racingCar.controller

import racingCar.controller.validation.AttemptCountValidation
import racingCar.controller.validation.CarsNameValidation
import racingCar.model.Car
import racingCar.model.CarName
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
       val cars = carsName.split(",").map { Car(CarName(it.trim())) }
       return Cars(cars)
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
