package racingcar.entity

data class Position(private var _value: Int) {
    var value: Int = _value
        get() = _value
        private set

    fun addPosition(length: Int) {
        _value += length
    }

    fun compareTo(position: Position): Boolean {
        return this.value >= position.value
    }
}
