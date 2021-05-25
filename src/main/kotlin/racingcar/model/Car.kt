package racingcar.model

class Car(val name: String, val position: Int = 0) {

    init {
        require(name.length <= MAX_NAME_LENGTH) {
            "자동차의 이름은 5글자를 초과할 수 없습니다."
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

    companion object {
        private const val MAX_NAME_LENGTH: Int = 5
    }
}
