package racingcar.domain

class Car(
    val name: String,
    var distance: Int = 0,
) {
    fun randomMove() = distance++

    fun printDistanceInfo() = println("$name : ${ "-".repeat(distance) }")
}
