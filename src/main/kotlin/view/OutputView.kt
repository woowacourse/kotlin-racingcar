package view

import model.CarPath
import model.PathState

object OutputView {

    private const val FINAL_WINNER = "최종 우승자: "
    private const val SEPARATOR = ", "

    fun printMsg(msg: String) {
        println(msg)
    }

    fun printResult(carsPath: List<CarPath>, numberOfTry: Int) {
        carsPath.forEach { carPath ->
            println(carPath.carName + " : " + carPath.subPath(numberOfTry).getPathMarks())
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        print(FINAL_WINNER)
        println(winners.joinToString(SEPARATOR))
    }

    private fun List<PathState>.getPathMarks(): String {
        var pathMarks = ""

        this.forEach { pathState ->
            pathMarks += pathState.state
        }

        return pathMarks
    }

    private fun CarPath.subPath(number: Int) = this.path.subList(0, number + 1)
}
