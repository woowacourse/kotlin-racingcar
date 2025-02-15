package controller

import model.Car
import model.Game
import view.InputView
import view.OutputView

class GameController {
    fun run() {
        val carNames = InputView.readCarNames()
        val cars = generateCars(carNames)
        val rounds = InputView.readRounds()
        val game = Game(cars, rounds)
        playGame(game)
        val winner = game.getWinner()
        OutputView.printWinner(winner)
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
            OutputView.printState(game)
        }
    }
}
