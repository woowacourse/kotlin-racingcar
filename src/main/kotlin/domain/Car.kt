package domain

class Car(
    val name: Name
) {
    var position: Position = Position()
        private set
    
    constructor(name: String) : this(Name(name))

    fun move(generator: NumberGenerator) {
        if (generator.generate() >= MOVING_STANDARD) {
            position = position.increase()
        }
    }

    fun isSamePosition(car: Car): Boolean {
        return this.position == car.position
    }

    companion object {
        const val MOVING_STANDARD: Int = 4
    }
}
