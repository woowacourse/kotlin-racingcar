package view

import data.CarPath
import util.FINAL_WINNER
import util.getPathMarks
import util.subPath
import view.View.bw

object OutputView {

    fun printMsg(msg: String) {
        bw.write(msg)
        bw.flush()
    }

    fun printResult(carsPath: List<CarPath>, numberOfTry: Int) {
        carsPath.forEach { carPath ->
            bw.write(carPath.carName + " : " + carPath.subPath(numberOfTry).getPathMarks() + "\n")
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
