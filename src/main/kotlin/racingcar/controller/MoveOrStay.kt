package racingcar.controller


class MoveOrStay() {
    fun decideMovement(randomNumber: Int): Boolean = randomNumber in move

    companion object{
        val move = 4..9
    }
}
