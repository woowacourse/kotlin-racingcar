fun main() {
    val world = World()
    world.init()
    for (i in 0 until world.attemptCount)
        world.run()
    world.quit()
}
