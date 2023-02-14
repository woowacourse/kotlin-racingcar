package racingcar

import racingcar.controller.World

fun main() {
    try {
        World()
    } catch (e: IllegalArgumentException) {
        println("[ERROR]: " + e.message)
    }
}
