package car

class Car (
    private val threshold: Int
) {
    var position: Int = 0
    private set

    fun isMovable(inputValue: Int): Boolean {
        return inputValue >= threshold
    }

    fun move(inputValue: Int) {
        if (isMovable(inputValue)) {
            position++
        }
    }
}