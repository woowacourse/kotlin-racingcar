package model

import util.Constants
import util.Validator

class Car(val name: String) {
    var position: Int = 0
        private set

    init {
        Validator().checkName(name)
    }

    fun move(random: Int) {
        if (random >= Constants.RANDOM_MOVE_LIMIT_NUM) position++
    }
}
