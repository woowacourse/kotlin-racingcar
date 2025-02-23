package racingcar

import racingcar.domain.MoveTable
import racingcar.view.View
import kotlin.random.Random

class Controller(
    private val raceService: RaceService,
    private val view: View,
    private val random: Random,
) {
    fun run() {
        val cars = view.getCars()
        val raceCount = view.getRaceCount()
        val moveTable = MoveTable.genTable(cars, raceCount, random)

        view.printResult(raceService.race(moveTable))
        view.printWinner(raceService.getWinner(cars))
    }
}
