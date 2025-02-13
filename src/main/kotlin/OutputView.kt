class OutputView {
    fun printResultTitle() = println(RESULT)

    fun printCarState(cars: List<Car>) {
        cars.forEach { car -> println("${car.name} : ${CAR_POSITION.repeat(car.position)}") }
        println()
    }

    fun printRaceWinner(winners: List<Car>) = println("$FINAL_WINNER ${winners.joinToString(", ") { winner -> winner.name }}")
}
