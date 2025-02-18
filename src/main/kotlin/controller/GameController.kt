package controller

import domain.Car
import domain.Game
import view.InputView
import view.OutputView

object GameController {
    fun run() {
        val game = initializeGame()
        game.play()
        announceResult(game)
    }

    private fun initializeGame(): Game {
        val carNames = getCarNames()
        val cars = generateCars(carNames)
        val rounds = getRounds()
        return Game(cars, rounds)
    }

    private fun getCarNames(): List<String> {
        OutputView.promptCarNamesInput()
        return InputView.readCarNames()
    }

    private fun generateCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }

    private fun getRounds(): Int {
        OutputView.promptRoundsInput()
        return InputView.readRounds()
    }

    private fun announceResult(game: Game) {
        OutputView.printResult(game.result)
        OutputView.printWinner(game.getWinner())
    }
}
