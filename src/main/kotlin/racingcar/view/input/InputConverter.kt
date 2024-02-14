package racingcar.view.input

import racingcar.constants.GameConstants
import racingcar.model.Car

class InputConverter {
    fun convertCars(inputCarNames: String?) =
        inputCarNames?.split(GameConstants.SPLIT_DELIMITER)?.map { Car(it) }
}
