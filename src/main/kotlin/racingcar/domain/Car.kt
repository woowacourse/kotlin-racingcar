package racingcar.domain

class Car(val name: String) {
    private var location = 0

    fun plusLocation() {
        this.location += 1
    }
}
