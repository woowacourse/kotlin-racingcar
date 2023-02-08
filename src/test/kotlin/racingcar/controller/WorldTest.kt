package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

class WorldTest {

    @Test
    fun determineWinner() {
        val world = World()
        world.cars.add(Car("test1"))
        world.cars.add(Car("test2"))
        world.cars.add(Car("test3"))

        world.processStep(world.cars[0], 3)
        world.processStep(world.cars[1], 4)
        world.processStep(world.cars[2], 7)
        world.processStep(world.cars[0], 2)
        world.processStep(world.cars[1], 1)
        world.processStep(world.cars[2], 4)

        val winners = world.determineWinner()
        assertThat(winners).isEqualTo(listOf(world.cars[2]))
    }
}
