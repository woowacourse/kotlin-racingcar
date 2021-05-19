package racingcar.controller

import racingcar.domain.Laps
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.input.InputView
import racingcar.input.OutputView
import java.util.*
import kotlin.streams.toList

class RacingGame(scanner: Scanner) {
    private val inputView = InputView(scanner)
    private val outputView = OutputView()

    fun playGame() {
        val players = initPlayers()
        val laps = inputView.inputLaps()

        rounds(laps, players)
        printWinner(players)
    }

    private fun rounds(laps: Laps, players: Cars) {
        outputView.printResult()

        var currentLap = laps
        while (!currentLap.isEnd()) {
            players.moveCars()
            outputView.printCars(players.cars())
            currentLap = currentLap.next()
        }
    }

    private fun initPlayers(): Cars {
        val carNames = inputView.inputCarNames()
        val carList = carNames.stream()
            .map { Car(it) }
            .toList()

        return Cars(carList)
    }

    private fun printWinner(players: Cars) {
        val winners = players.findWinners()
        outputView.printWinners(winners.cars())
    }
}