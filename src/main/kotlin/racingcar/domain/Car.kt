package racingcar.domain

import racingcar.domain.strategy.MoveStrategy

class Car(
    val name: String,
) {
    var distance: Int = 0
        private set

    init {
        carNameLengthCheck(name)
    }

    fun moveByStrategy(moveStrategy: MoveStrategy) {
        if (moveStrategy.isMove()) distance++
    }

    companion object {
        private fun carNameLengthCheck(name: String) {
            require(name.length in 1..5) { Messages.ERROR_NAME_LENGTH.message }
        }
    }
}
