package racingcar.model

class Car(val name: String, val position: Int = 0) {

    companion object {
        const val MOVE_PIVOT: Int = 4
        const val MAX_NAME_LENGTH: Int = 5
    }

    init {
        if (name.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.")
        }
    }

    fun move(condition: Int) : Car{
        if (condition >= MOVE_PIVOT) {
            return Car(name, position + 1)
        }
        return this
    }

}
