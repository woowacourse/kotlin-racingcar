import Constants.MOVING_STANDARD

class Car(carName: String) {
    private var distance: Int = 0

    fun moveOrStop(numberGenerator: NumberGenerator) {
        val randomNumber = numberGenerator.generate()
        if(isMovable(randomNumber)) ++distance
    }

    private fun isMovable(number : Int) = number >= MOVING_STANDARD
}