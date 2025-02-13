package racingcar

import racingcar.domain.Car
import racingcar.domain.Messages

class InputInitializer {
    companion object {
        private val inputValidator = InputValidator()

        fun getCars(): List<Car> {
            println(Messages.GAME_START.message)
            return inputValidator.carNamesValidate(readln())
        }

        fun getRaceCount(): Int {
            println(Messages.GAME_INPUT_COUNT.message)
            return inputValidator.tryCountValidate(readln())
        }
    }
}
