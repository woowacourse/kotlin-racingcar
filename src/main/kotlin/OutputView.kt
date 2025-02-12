class OutputView {
    fun printCarState(cars: List<Car>) {
        println("실행 결과")
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printRaceWinner(cars: List<Car>) {
        val maxPosition = cars.maxOf { car -> car.position }
        println("최종 우승지: ${cars.filter { car -> car.position == maxPosition }.joinToString(", ")}")
    }
}