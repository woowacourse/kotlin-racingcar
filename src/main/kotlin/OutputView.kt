import View.bw

object OutputView {

    fun printMsg() {
        bw.write(RESULT)
        bw.flush()
    }

    fun printResult(carsPath: List<CarPath>, numberOfTry: Int) {
        carsPath.forEach { carPath ->
            bw.write(carPath.carName + " : " + carPath.path.subList(0, numberOfTry + 1).getPathMarks() + "\n")
            bw.flush()
        }
        bw.write("\n")
        bw.flush()
    }

    fun printWinner(winners: List<String>) {
        bw.write(FINAL_WINNER)
        bw.write(winners.joinToString(", ") + '\n')
        bw.flush()
    }
}
