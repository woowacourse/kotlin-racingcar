package view

import data.CarPath
import data.CarPath.Companion.subPath
import data.PathState.Companion.getPathMarks

object OutputView {

    private const val RESULT = "실행 결과\n"
    private const val FINAL_WINNER = "최종 우승자: "
    private const val TOKENIZER = ", "
    private const val CAR_PATH = "%s : %s"

    fun printResult(carsPath: List<CarPath>, numberOfTry: Int) {
        carsPath.forEach { carPath ->
            println(CAR_PATH.format(carPath.carName, carPath.subPath(numberOfTry).getPathMarks()))
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        println(FINAL_WINNER)
        println(winners.joinToString(TOKENIZER))
    }
}
