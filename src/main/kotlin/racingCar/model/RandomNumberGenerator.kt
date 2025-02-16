package racingCar.view.model

import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(MAX_VALUE)
    }

    companion object {
        const val MAX_VALUE = 9
    }
}
