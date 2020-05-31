package domain.car

data class Position(
    var position: Int = 0
) {
    fun goForward() {
        position++
    }
}