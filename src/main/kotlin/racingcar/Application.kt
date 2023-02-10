package racingcar

import racingcar.controller.World

fun main() {
    runCatching {
        val world = World()
        world.run()
        world.quit()
    }.onFailure {
        println("[ERROR]: " + it.message)
    }
}
