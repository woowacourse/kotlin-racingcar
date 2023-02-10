package data

import InputError
import data.generator.NumberGenerator
import data.generator.RacingNumberGenerator
import data.generator.RacingNumberGenerator.Companion.MINIMUM_NUMBER_TO_MOVE

class Car(
    val name: String,
    private val racingNumberGenerator: NumberGenerator = RacingNumberGenerator()
) {
    var position = INITIAL_POSITION
        private set

    init {
        require(name.length <= NAME_LENGTH_LIMIT) {
            InputError.CAR_NAME_ERROR
        }
    }

    fun move() {
        if (racingNumberGenerator.generate() >= MINIMUM_NUMBER_TO_MOVE) {
            position++
        }
    }

    companion object {
        private const val NAME_LENGTH_LIMIT = 5
        const val INITIAL_POSITION = 0
    }
}
