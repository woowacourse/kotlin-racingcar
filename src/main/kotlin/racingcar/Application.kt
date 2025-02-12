package racingcar

import racingcar.Messages.*
fun main() {
    Application.run()
}

class Application{

    companion object {
        fun run() {
            println(GAME_START.message)
            val namesInput = readln()
            val names: List<String> = namesInput.split(",")

            println(GAME_INPUT_COUNT.message)
            val raceCount: Int = readln().toInt()
        }
    }
}