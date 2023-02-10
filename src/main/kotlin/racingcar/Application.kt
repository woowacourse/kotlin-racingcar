package racingcar

import racingcar.controller.World

fun main() {
    runCatching {
        val world = World()
        world.startRace()
        world.finishRace()
    }.onFailure {
        println("[ERROR]: " + it.message)
    }
}
