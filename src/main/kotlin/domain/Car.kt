package domain

class Car(val name: String, private var moveCount: Int) {
    private fun move() {
        moveCount++
    }

    fun tryMove(generator: CarNumberGenerator) {
        val number = generator.generate()
        if (number >= MIN_MOVE_NUMBER) move()
    }

    fun getMoveCount() = moveCount

    companion object {
        private const val MIN_MOVE_NUMBER = 4
    }
}
