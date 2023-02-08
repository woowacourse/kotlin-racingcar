import View.bw

object OutputView {

    fun printResult(carsPath: List<CarPath>, numberOfTry: Int) {
        carsPath.forEach { carPath ->
            bw.write(carPath.carName + " : " + carPath.path.subList(0, numberOfTry + 1).getPathMarks() + "\n")
            bw.flush()
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        winners.forEach { winner ->
            bw.write("$winner, ")
            bw.flush()
        }
    }
}
