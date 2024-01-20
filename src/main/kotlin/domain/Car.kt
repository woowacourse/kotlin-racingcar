package domain

class Car(val name: String, var distance: Int = 0) {

    companion object {
        private const val LIMIT_NAME_LENGTH_NUMBER = 5
        private const val FORWARD_STANDARD_NUMBER = 4
    }

    init {
        if (name.length > LIMIT_NAME_LENGTH_NUMBER) {
            throw IllegalArgumentException("차 이름은 5글자를 초과 할 수 없다.")
        }
    }

    fun movingForward(forwardNumber: Int) {
        if (forwardNumber >= FORWARD_STANDARD_NUMBER) {
            distance++
        }
        return
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

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
