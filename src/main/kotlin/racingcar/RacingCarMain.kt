package racingcar

import racingcar.ui.printRoundResult
import racingcar.ui.printRoundResultMessage
import racingcar.ui.printWinners
import racingcar.utils.getCarInput
import racingcar.utils.getRoundInput

fun main() {
    val cars = getCarInput()
    val round = getRoundInput()

    printRoundResultMessage()
    for (i: Int in 0..round) {
        cars.proceed()
        printRoundResult(cars.getCars())
    }
    printWinners(cars.findWinners())
}
