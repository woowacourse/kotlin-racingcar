package racingcar

import racingcar.controller.World

fun main() {
    try {
        val world = World()
        world.init()
        for (i in 0 until world.attemptCount)
            world.run()
        world.quit()
    } catch (e: IllegalArgumentException) {
        println("[ERROR]: " + e.message)
    } catch (e: IllegalStateException) {
        println("[ERROR]: " + e.message)
    }
}
