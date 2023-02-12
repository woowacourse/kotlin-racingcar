package racingcar.entity

data class Position(private var _value: Int) {
    val value: Int get() = _value

    fun addPosition(length: Int) {
        _value += length
    }

    fun compareTo(position: Position): Boolean {
        return this.value >= position.value
    }
}
