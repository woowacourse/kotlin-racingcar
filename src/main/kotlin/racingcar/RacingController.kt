package racingcar

import racingcar.model.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private fun race(
        count: Int,
        cars: Cars,
    ) {
        outputView.printResultHeader()
        repeat(count) {
            val result = cars.playRound()
            outputView.printRound(result)
            println()
        }
    }

    fun start() {
        val carInput = inputView.readCars()
        val cars = Cars()
        cars.generateCars(carInput)
        val count = inputView.readCount()
        race(count, cars)
        val winner = cars.getWinner()
        outputView.printWinner(winner)
    }
}
