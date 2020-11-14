package racingcar.domain

import kotlin.random.Random

private const val MAX_POWER = 10

object RandomPower {
    fun generate() = Random.nextInt(MAX_POWER)
}

