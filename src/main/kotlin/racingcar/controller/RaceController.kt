package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {

    fun run() {
        val names: List<String> = InputView.inputNames().split(DELIMITER)
        val namesToCar: ArrayList<Car> = names
            .map { name -> Car(name) }
            .toCollection(arrayListOf())
        val cars = Cars(namesToCar)
        val laps = InputView.inputLaps()

        race(laps, cars)
        OutputView.printWinners(cars.winners())
    }

    private fun race(laps: Int, cars: Cars) {
        OutputView.printRaceInitMessage()
        for (i in 0 until laps) {
            cars.race()
            OutputView.printStatus(cars.status())
        }
    }

    companion object {
        private const val DELIMITER = ","
    }
}
