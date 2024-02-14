package model

import kotlin.random.Random

class RandomNumber {
    fun generate(): Int {
        return Random.nextInt(0, 9)
    }
}