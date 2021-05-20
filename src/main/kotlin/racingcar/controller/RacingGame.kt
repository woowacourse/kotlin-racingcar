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
        val cars = initCars()
        val laps = initLaps()

        rounds(laps, cars)
        printWinner(cars)
    }

    private fun rounds(laps: Laps, cars: Cars) {
        outputView.printResult()

        var currentLap = laps
        while (!currentLap.isEnd()) {
            cars.moveCars()
            outputView.printCars(cars)
            currentLap = currentLap.next()
        }
    }

    private fun printWinner(cars: Cars) {
        val winners = cars.findWinners()
        outputView.printWinners(winners)
    }

    private fun initLaps(): Laps {
        return inputView.inputLaps()
    }

    private fun initCars(): Cars {
        val carNames = inputView.inputCarNames()
        val carList = carNames.stream()
            .map { Car(it) }
            .toList()

        return Cars(carList)
    }
}