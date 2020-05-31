package car

class Car (
    private val threshold: Int
) {
    val position: Position = Position()

    fun isMovable(inputValue: Int): Boolean {
        return inputValue >= threshold
    }

    fun move(inputValue: Int) {
        if (isMovable(inputValue)) {
            position.goForward()
        }
    }
}