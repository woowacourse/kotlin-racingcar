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
            require(name.length in 1..5) { ERROR_NAME_LENGTH }
        }

        private const val ERROR_NAME_LENGTH = "자동차 이름을 1자 이상 5자 이하로 입력하세요."
    }
}
