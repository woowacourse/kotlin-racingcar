package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {

    fun run() {
        val names: List<String> = InputView.inputNames().split(DELIMITER)
        val namesToCar: List<Car> = names
            .map { name -> Car(name = name) }
        val cars = Cars(namesToCar)
        val laps = InputView.inputLaps()

        race(laps, cars)
        OutputView.printWinners(cars.winners())
    }

    private fun race(laps: Int, cars: Cars) {
        OutputView.printRaceInitMessage()
        repeat(laps) {
            cars.race()
            OutputView.printStatus(cars.status())
        }
    }

    companion object {
        private const val DELIMITER = ","
    }
}

fun main() {
    val controller = RaceController()
    controller.run()
}
