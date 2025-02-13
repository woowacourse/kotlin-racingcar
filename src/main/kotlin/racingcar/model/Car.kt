package racingcar.model

import racingcar.enums.Move

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move(moveState: Move) {
        when (moveState) {
            Move.MOVABLE -> position++
            Move.UNMOVABLE -> return
        }
    }
}
