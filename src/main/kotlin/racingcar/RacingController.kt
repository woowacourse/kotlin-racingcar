package racingcar

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private fun generateCars(carInput: List<String>): Cars {
        val carList = carInput.map { Car(it) }
        return Cars(carList)
    }

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
        val cars = generateCars(carInput)
        val count = inputView.readCount()
        race(count, cars)
        val winner = cars.getWinner()
        outputView.printWinner(winner)
    }
}
