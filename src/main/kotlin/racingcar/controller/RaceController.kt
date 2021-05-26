package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.view.*

private const val DELIMITER = ","

class RaceController {

    fun run() {
        val names: List<String> = inputNames().split(DELIMITER)
        val cars = Cars(names.map { Car(name = it) }.toMutableList())
        val laps = inputLaps()

        race(laps, cars)
        printWinners(cars.winners())
    }

    private fun race(laps: Int, cars: Cars) {
        printRaceInitMessage()
        repeat(laps) {
            cars.race()
            printStatus(cars.status())
        }
    }
}
