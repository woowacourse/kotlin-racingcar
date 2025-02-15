package racingcar

import racingcar.domain.Car
import racingcar.domain.Configure.Companion.RANDOM_SEED
import racingcar.domain.Messages
import kotlin.random.Random

class RaceService {
    private val random = Random(RANDOM_SEED)
    private val outputView = OutputView()

    fun getWinCars(cars: List<Car>): List<Car> = cars.filter { it.distance == cars.maxOf { car -> car.distance } }

    fun showCarNamesByWinnerFormat(cars: List<Car>) =
        outputView.printToConsole(Messages.WINNER_NAMES_ANNOUNCE.formattedMessage(cars.joinToString(", ") { it.name }))

    fun repeatRaceByCount(
        raceCount: Int,
        cars: List<Car>,
    ) {
        repeat(raceCount) {
            doSingleRace(cars)
            outputView.printToConsole("", true)
        }
    }

    private fun doSingleRace(cars: List<Car>) {
        cars.forEach { car ->
            car.moveByValue(random.nextInt(0, 10))
            outputView.printToConsole(car.toString(), true)
        }
    }
}
