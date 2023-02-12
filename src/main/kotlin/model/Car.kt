package model

import util.Validator

class Car(val name: String) {
    var position: Int = 0
        private set

    init {
        Validator().checkName(name)
    }

    fun move(random: Int) {
        if (random >= RANDOM_MOVE_LIMIT_NUM) position++
    }

    companion object {
        const val RANDOM_MOVE_LIMIT_NUM = 4
    }
}
