package domain

class Car(val name: String) {
    var distance: Int = 0
        private set

    fun movingForward(forwardNumber: Int) {
        if (forwardNumber >= 4) {
            distance++
        }
        return
    }


}
