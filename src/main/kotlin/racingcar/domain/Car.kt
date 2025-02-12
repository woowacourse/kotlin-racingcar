package racingcar.domain

class Car(val carName: String) {
    val moveOrStop = mutableListOf<String>()

    fun moves(isMove: Boolean) {
        when (isMove) {
            true -> moveOrStop.add("-")
            false -> moveOrStop.add("")
        }
    }

    fun moveCount(): Int {
        return moveOrStop.count { it == "-" }
    }
}
