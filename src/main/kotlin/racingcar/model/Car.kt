package racingcar.model

class Car(val position: Int = 0) {

    companion object {
        const val MOVE_PIVOT: Int = 4
    }

    fun move(condition: Int) {
        if (condition >= MOVE_PIVOT) {
            return Car(position + 1)
        }
        return this
    }

}
