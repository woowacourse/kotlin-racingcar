package racingcar

class Car(var position: Int = 0) {

    companion object {
        const val MOVE_PIVOT: Int = 4
    }

    fun move(condition: Int) {
        if (condition >= MOVE_PIVOT) {
            position++
        }
    }

}
