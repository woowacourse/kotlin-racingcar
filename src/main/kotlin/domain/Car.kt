package domain

class Car(name: String) {

    companion object {
        private const val LIMIT_NAME_LENGTH_NUMBER = 5
        private const val FORWARD_STANDARD_NUMBER = 4
    }

    var distance: Int = 0
        private set

    init {
        if (name.length >= LIMIT_NAME_LENGTH_NUMBER) {
            throw IllegalArgumentException("차 이름은 5글자를 초과 할 수 없다.")
        }
    }

    fun movingForward(forwardNumber: Int) {
        if (forwardNumber >= FORWARD_STANDARD_NUMBER) {
            distance++
        }
        return
    }


}
