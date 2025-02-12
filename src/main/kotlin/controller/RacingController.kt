package controller

import model.AttemptCount
import model.Cars
import model.Race

class RacingController(
    private val userInterface: UserInterface = UserInterface(),
) {
    fun run() {
        val cars = getCarNames()
        val attemptCount = getAttemptCount()
        val race = Race(cars)
        playRacing(cars, attemptCount, race)
        val winners = race.getWinner()
        userInterface.handleWinnerMessage(winners)
    }

    private fun getCarNames(): Cars = Cars(userInterface.handleStartMessage())

    private fun getAttemptCount(): AttemptCount = AttemptCount(userInterface.handleAttemptCountMessage())

    private fun playRacing(
        cars: Cars,
        attemptCount: AttemptCount,
        race: Race,
    ) {
        userInterface.handleStartRoundMessage()
        repeat(attemptCount.getCount()) {
            race.playOneRound()
            userInterface.handleRoundResultMessage(cars)
        }
    }

    private fun showWinners(race: Race) {
        val winners = race.getWinner()
        userInterface.handleWinnerMessage(winners)
    }
}
