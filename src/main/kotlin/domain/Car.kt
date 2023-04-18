package domain

private const val MOVE_CONDITION = 4
private const val INIT_POSITION = 0

class Car(val name: Name) {

    var position: Position = Position(INIT_POSITION)
        private set

    fun move(numberGenerator: NumberGenerator) {
        if (numberGenerator.generate() >= MOVE_CONDITION) {
            this.position = position.increase()
        }
    }

    fun isSamePosition(position: Int): Boolean {
        return this.position.value == position
    }
}
