package controller

import model.Car
import model.Game
import view.InputView
import view.OutputView

object GameController {
    fun run() {
        val game = initializeGame()
        playGame(game)
        announceResult(game)
    }

    private fun initializeGame(): Game {
        val carNames = InputView.readCarNames()
        val cars = generateCars(carNames)
        val rounds = InputView.readRounds()
        return Game(cars, rounds)
    }

    private fun generateCars(carNames: List<String>): List<Car> {
        val cars = mutableListOf<Car>()
        carNames.map { cars.add(Car(it)) }
        return cars
    }

    private fun playGame(game: Game) {
        OutputView.printResultHeader()
        repeat(game.rounds) {
            game.moveCars()
            OutputView.printState(game.cars)
        }
    }

    private fun announceResult(game: Game) {
        val winner = game.getWinner()
        OutputView.printWinner(winner)
    }
}
