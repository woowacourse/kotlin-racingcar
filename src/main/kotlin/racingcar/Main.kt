package racingcar

fun main() {
    val cars: List<Car> = Input().readCars()
    val round: Int = Input().readRound()
    println("\n실행결과")
    val racecourse = Racecourse(cars, round)
    racecourse.startRace()
}

fun String.toCars(): List<Car> =
    split(",")
        .map { it.trim() }
        .filter { it.isNotBlank() }
        .map { name -> Car(name) }
