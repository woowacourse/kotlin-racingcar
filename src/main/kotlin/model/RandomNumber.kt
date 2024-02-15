package model

import util.NumberGenerator
import kotlin.random.Random

class RandomNumber : NumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(0, 9)
    }
}