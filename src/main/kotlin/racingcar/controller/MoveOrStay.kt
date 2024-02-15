package racingcar.controller

import racingcar.model.Ranges

class MoveOrStay() {
    fun decideMovement(randomNumber: Int): Boolean = randomNumber in Ranges.move
}
