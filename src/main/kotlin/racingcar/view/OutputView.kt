package racingcar.view

class OutputView {
    fun showFinalWinner(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }

    fun showRaceInfo(raceInfo: List<Map<String, Int>>) {
        println("\n실행 결과")
        raceInfo.forEach {
            showSingleRaceInfo(it)
        }
    }

    private fun showSingleRaceInfo(singleRace: Map<String, Int>) {
        singleRace.forEach {
            println("${it.key}: ${"-".repeat(it.value)}")
        }
        println()
    }
}
