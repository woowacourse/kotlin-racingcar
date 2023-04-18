package domain

import java.util.*

class RandomNumberGenerator: NumberGenerator {
    override fun generate(): Int {
        val random = Random()
        return random.nextInt(10)
    }
}
