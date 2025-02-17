package racingcar.controller

import racingcar.domain.model.AttemptCount
import racingcar.domain.model.Cars

class RacingController(
    private val userInterface: UserInterface = UserInterface(),
) {
    fun run() {
        val cars = getCarNames()
        val attemptCount = getAttemptCount()
        playRacing(cars, attemptCount)
        showWinners(cars)
    }

    private fun getCarNames(): Cars {
        val input = userInterface.handleStartMessage()
        val carNames = input.split(",")
        return Cars(carNames)
    }

    private fun getAttemptCount(): AttemptCount = AttemptCount(userInterface.handleAttemptCountMessage())

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
