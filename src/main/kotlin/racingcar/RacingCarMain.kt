package racingcar

import racingcar.service.RacingService
import racingcar.ui.printRoundResultMessage
import racingcar.ui.printWinners
import racingcar.utils.getCarNamesInput
import racingcar.utils.getRoundInput

fun main() {
    val cars = getCarNamesInput()
    val round = getRoundInput()
    val racingService = RacingService(cars)
    printRoundResultMessage()
    racingService.race(round)
    printWinners(racingService.findWinners())
}