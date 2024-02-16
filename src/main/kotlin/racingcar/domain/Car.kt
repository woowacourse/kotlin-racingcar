package racingcar.domain

import racingcar.constant.MoveConstant


class Car(val name: String) {
    var position: Int = 0
        private set

    fun move(number: Int) {
        if (number >= MoveConstant.FORWARD_NUMBER) position++
    }
}
