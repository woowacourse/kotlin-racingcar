package view

import model.CarPath
import model.PathState

object OutputView {

    private const val FINAL_WINNER = "최종 우승자: "
    private const val SEPARATOR = ", "
    private const val MOVE_MARK = "-"
    private const val STOP_MARK = ""

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
            pathMarks += pathState.changeToMark()
        }

        return pathMarks
    }

    private fun PathState.changeToMark(): String = when (this) {
        PathState.MOVE -> MOVE_MARK
        PathState.STOP -> STOP_MARK
    }

    private fun CarPath.subPath(number: Int) = this.path.subList(0, number + 1)
}
