package domain

import exception.InvalidCarNameException

class Car(val name: String, distance: Int) {
    var distance: Int = distance
        private set

    constructor(name: String) : this(name, 0)
    constructor(name: String, distance: Int?) : this(name, 0)

    init {
        validateCarName(name)
    }

    private fun validateCarName(name: String) {
        if (name.isEmpty()) {
            throw InvalidCarNameException("not allowed empty")
        }
        if (name.contains(" ")) {
            throw InvalidCarNameException("not allowed blank")
        }
    }

    fun move() {
        this.distance++
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        if (name != other.name) return false
        if (distance != other.distance) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + distance
        return result
    }
}
