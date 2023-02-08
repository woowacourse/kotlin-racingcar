package racingcar

import racingcar.domain.RacingGame

fun main() {
    try {
        RacingGame().runGame()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
