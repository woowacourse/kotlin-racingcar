package controller

import model.Car
import model.Game
import view.InputView
import view.OutputView

object GameController {
    fun run() {
        val game = initializeGame()
        game.play()
        announceResult(game)
    }

    private fun initializeGame(): Game {
        val carNames = InputView.readCarNames()
        val cars = generateCars(carNames)
        val rounds = InputView.readRounds()
        return Game(cars, rounds)
    }

    private fun generateCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }

    private fun announceResult(game: Game) {
        OutputView.printResult(game.result)
        val winner = game.getWinner()
        OutputView.printWinner(winner)
    }
}
