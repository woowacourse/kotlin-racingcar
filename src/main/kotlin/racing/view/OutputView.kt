package racing.view

object OutputView {

    fun printGameResult(cars: List<String>, carsMoveProgress: List<List<Int>>) {
        println("실행 결과")
        repeat(carsMoveProgress.size) {
            printCurrentPosition(cars, carsMoveProgress[it])
        }
    }

    private fun printCurrentPosition(carNames: List<String>, carsMoveProgress: List<Int>) {
        carNames.forEachIndexed { index, carName ->
            println("$carName : ${getDash(carsMoveProgress[index])}")
        }
        println()
    }

    private fun getDash(position: Int): String {
        val result = StringBuilder()
        repeat(position) {
            result.append("-")
        }
        return result.toString()
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자: ${winners.joinToString(", ")}")
    }
}


