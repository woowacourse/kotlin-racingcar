package car

class Car (
    private val threshold: Int
) {
    fun isMovable(inputValue: Int): Boolean {
        return inputValue >= threshold
    }
}