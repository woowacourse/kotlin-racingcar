package racingcar.model

const val MAX_NAME_LENGTH = 5

class Car(val name: String, val position: Int = 0) {

    init {
        if (name.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.")
        }
    }

    fun move(moveStrategy: MoveStrategy): Car {
        if (moveStrategy.move()) {
            return Car(name, position + 1)
        }
        return this
    }

    fun isSamePosition(position: Int): Boolean {
        return this.position == position
    }
}
