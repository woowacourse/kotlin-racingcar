package racingcar

import racingcar.Messages.*
import racingcar.InputValidator

fun main() {
    Application.run()
}

class Application{

    companion object {
        fun run() {
            val inputValidator = InputValidator()

            println(GAME_START.message)
            val namesInput = readln()
            inputValidator.carNamesValidate(namesInput)
            val names: List<String> = namesInput.split(",")

            println(GAME_INPUT_COUNT.message)
            val raceCountInput = readln()
            inputValidator.tryCountValidate(raceCountInput)
            val raceCount: Int = raceCountInput.toInt()
        }
    }
}