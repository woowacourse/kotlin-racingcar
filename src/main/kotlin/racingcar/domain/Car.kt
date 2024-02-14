package racingcar.domain

import kotlin.random.Random

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move() {
        val randomNumber = Random.nextInt(10)
        if (randomNumber >= 4) position++
    }
}