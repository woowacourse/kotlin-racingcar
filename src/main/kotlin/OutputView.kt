class OutputView {
    fun printDuplicate() {
        println(CAR_DUPLICATE_REMOVE)
    }

    fun printResultTitle() = println(RESULT)

    fun printCarState(cars: List<Car>) {
        cars.forEach { car -> println("${car.name}${CAR_STATE_DELIMITER}${CAR_POSITION.repeat(car.position)}") }
        println()
    }

    fun printRaceWinner(winners: List<Car>) = println("$FINAL_WINNER ${winners.joinToString(WINNER_DELIMITER) { winner -> winner.name }}")
}
