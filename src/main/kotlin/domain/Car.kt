package domain

private const val MOVE_CONDITION = 4

class Car(val name: Name, private var position: Position) {

    fun move(numberGenerator: NumberGenerator) {
        if (numberGenerator.generate() >= MOVE_CONDITION) {
            this.position = position.increase()
        }
    }

    fun isSamePosition(position: Position): Boolean {
        return this.position == position
    }
}
