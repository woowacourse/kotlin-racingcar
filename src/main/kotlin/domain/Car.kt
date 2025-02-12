package domain

import kotlin.random.Random
import kotlin.random.nextInt

class Car (
    val name: String,
    var position: Int = 0
){
    fun move() {
        if (Random.nextInt(0..9) >= 4) {
            ++position
        }
    }
}