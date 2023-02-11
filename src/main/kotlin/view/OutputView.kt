package view

import data.Car

object OutputView {

    private const val RESULT = "실행 결과\n"
    private const val FINAL_WINNER = "최종 우승자: "
    private const val CAR_PATH = "%s : %s"
    private const val DASH = "-"
    private const val INITIAL_NUMBER_OF_TRY = 0
    private const val TOKENIZER = ","

    fun printErrorMsg(msg: String) {
        println(msg)
    }

    fun printWinner(winners: List<String>) {
        println(FINAL_WINNER)
        println(winners.joinToString("$TOKENIZER "))
    }

    fun printPath(numberOfTry: Int, cars: List<Car>) {
        if (numberOfTry == INITIAL_NUMBER_OF_TRY) {
            println(RESULT)
        }

        cars.forEach { car ->
            println(CAR_PATH.format(car.name, DASH.repeat(car.position)))
        }
    }
}
