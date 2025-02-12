class OutputView {
    fun printResultTitle() = println("실행 결과")

    fun printCarState(cars: List<Car>) {
        cars.forEach { car -> println("${car.name} : ${"-".repeat(car.position)}") }
        println()
    }

    fun printRaceWinner(winners: List<Car>) = println("최종 우승자: ${winners.joinToString(", ") { winner -> winner.name }}")
}
