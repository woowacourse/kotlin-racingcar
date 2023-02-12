package domainTest.gameTest

import domain.generator.CarGenerator
import domain.generator.NumberGenerator

open class GameBaseTest {

    protected val carGenerator = CarGenerator()

    protected val stopCars = carGenerator.generateCars(
        names = listOf("제임스", "우기"),
        numberGenerator = object : NumberGenerator {
            override fun generate(): Int = MAXIMUM_NUMBER_TO_STOP
        }
    )

    protected val movingCars = carGenerator.generateCars(
        names = listOf("제임스", "우기"),
        numberGenerator = object : NumberGenerator {
            override fun generate(): Int = MINIMUM_NUMBER_TO_MOVE
        }
    )

    companion object {
        private const val MAXIMUM_NUMBER_TO_STOP = 3
        private const val MINIMUM_NUMBER_TO_MOVE = 4
        const val INITIAL_POSITION = 0
    }
}
