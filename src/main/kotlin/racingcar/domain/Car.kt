package racingcar.domain

import kotlin.random.Random

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move() {
        val number: Int = Random.nextInt(10)
        if (number >= 4) position++
    }
}
