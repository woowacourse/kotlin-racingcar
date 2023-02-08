import View.bw

object OutputView {

    fun printResult(carsPath: List<CarPath>, numberOfTry: Int) {

        carsPath.forEach { carPath ->
            bw.write(carPath.carName + " : " + carPath.path.subList(0,numberOfTry).joinToString("") + "\n")
            bw.flush()
        }
        println()
    }

    fun printWinner(cars: List<Car>) {
        cars.forEach { car ->
            bw.write(car.getName() + ", ")
            bw.flush()
        }
    }
}
