package racingcar.domain

class Car(
    val name: String,
    var distance: Int = 0,
) {
    fun moveForward() = distance++

    fun getDistanceInfo() = "$name : ${"-".repeat(distance)}"
}
