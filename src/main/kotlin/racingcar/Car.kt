package racingcar

class Car(val carName: String) {
    private val moveOrStop = mutableListOf<String>()

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
//val moves = listOf("-","","-","-")