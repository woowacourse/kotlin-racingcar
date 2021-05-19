package racingcar.domain

import java.lang.IllegalArgumentException

data class Car(private val strategy: MoveStrategy, val name: String) {
    private var position: Int = 0

    constructor(strategy: MoveStrategy) : this(strategy, "abc")
    constructor(name: String) : this(RandomMoveStrategy, name)

    fun move() {
        if (strategy.isMovable()) {
            position += 1
        }
    }

    fun isSamePosition(position: Int): Boolean {
        return this.position == position
    }

    fun getPosition():Int {
        return position
    }
init{
    validateName(name)
}

    private fun validateName(name: String) {
        if(name.length > 5|| name.isEmpty()){
            throw IllegalArgumentException("이름은 1 ~ 5 사이의 길이여야합니다.")
        }

    }
}