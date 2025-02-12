class OutputView {
    fun printCarState(cars: List<Car>) {
        println("실행 결과")
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }
}