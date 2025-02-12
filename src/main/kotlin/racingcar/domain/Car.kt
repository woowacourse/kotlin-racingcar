package racingcar.domain

import kotlin.random.Random

class Car(val name: String, private val random: Random, var distance: Int = 0) {
    fun randomMove() {
        if (random.nextInt(0, 10) >= 4) distance++
    }

    fun printDistanceInfo() = println("$name : ${ "-".repeat(distance) }")
}
