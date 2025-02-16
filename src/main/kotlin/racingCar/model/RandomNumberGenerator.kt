package racingCar.model

import kotlin.random.Random

class RandomNumberGenerator(private val maxValue: Int) : NumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(maxValue)
    }
}
