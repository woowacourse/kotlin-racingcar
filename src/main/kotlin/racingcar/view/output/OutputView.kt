package racingcar.view.output

import racingcar.constants.GameConstants
import racingcar.constants.OutputConstants
import racingcar.model.Car

class OutputView {
    fun printInputCarNamesMessage() {
        print(OutputConstants.INPUT_CAR_NAMES_MESSAGE)
    }

    fun printInputTryCountMessage() {
        print(OutputConstants.INPUT_TRY_COUNT_MESSAGE)
    }

    fun printProcessStep(cars: List<Car>) {
        cars.forEach { car ->
            println(car.getStepState())
        }
    }

    fun printWinners(winners: List<Car>) {
        print(OutputConstants.WINNERS_MESSAGE + winners.joinToString(GameConstants.SPLIT_DELIMITER))
    }
}