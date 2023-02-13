package racingcar.entity

data class Position(val value: Int) {
    fun compareTo(position: Position): Boolean {
        return this.value >= position.value
    }
}
