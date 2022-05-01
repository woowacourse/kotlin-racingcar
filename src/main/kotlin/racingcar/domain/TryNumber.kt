package racingcar.domain

import racingcar.util.parseInt

data class TryNumber(private var value: Int) {

    constructor(input: String) : this(parseInt(input))

    init {
        require(value > 0) { "이동횟수는 양수여야 합니다." }
    }

    fun decrease() {
        this.value--
    }

    fun isGameOver(): Boolean {
        return this.value <= 0
    }
}
