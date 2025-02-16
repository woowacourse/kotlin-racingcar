package racingcar.view

class OutputView {
    fun showFinalWinner(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }

    fun showRaceResultHeader() {
        println("\n실행 결과")
    }

    fun showSingleRaceInfo(singleRace: Map<String, Int>) {
        singleRace.forEach {
            println("${it.key}: ${"-".repeat(it.value)}")
        }
        println()
    }
}
