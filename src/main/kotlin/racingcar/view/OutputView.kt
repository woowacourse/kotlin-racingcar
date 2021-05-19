package racingcar.view

object OutputView {

    fun printRaceInitMessage() {
        println("실행결과")
    }

    fun printStatus(result:LinkedHashMap<String, Int>) {
        for(name in result.keys){
            val position = result[name]!!
            var processBar = ""
            for (i in 0 until position){
                processBar += "-"
            }
            println("$name : $processBar")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println(winners.joinToString() + "가 최종 우승했습니다.")
    }
}