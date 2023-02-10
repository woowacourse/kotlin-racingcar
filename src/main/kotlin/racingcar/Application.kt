package racingcar

import racingcar.controller.World

fun main() {
    try {
        val world = World()
        world.run()
        world.quit()
    } catch (e: Exception) {
        when (e) {
            is IllegalArgumentException, is IllegalStateException -> {
                println("[ERROR]: " + e.message)
            }
        }
    }
}
