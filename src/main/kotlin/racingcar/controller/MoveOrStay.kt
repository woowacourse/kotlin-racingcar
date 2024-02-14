package racingcar.controller

class MoveOrStay() {
    fun decideMovement(randomNumber: Int): Boolean = randomNumber in 4..9
}
