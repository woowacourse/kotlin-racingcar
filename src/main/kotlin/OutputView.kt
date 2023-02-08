import View.bw

object OutputView {

    fun printResult(cars: List<Car>) {
        cars.forEach { car ->
            bw.write(car.getCar().first + " : " + "-".repeat(car.getCar().second) + "\n")
            bw.flush()
        }
        println()
    }

    fun printWinner(cars: List<Car>) {
        cars.forEach { car ->
            bw.write(car.getCar().first + ", ")
            bw.flush()
        }
    }
}
