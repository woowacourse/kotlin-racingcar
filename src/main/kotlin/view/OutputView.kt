package view

import domain.Car

class OutputView {

    fun printCarNamesPrompt() {
        println(CAR_NAMES_PROMPT)
    }

    fun printRoundCountPrompt() {
        println(ROUND_COUNT_PROMPT)
    }

    fun printRoundResultMessage() {
        println(ROUND_RESULT_MESSAGE)
    }

    fun printRoundResult(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.getMoveCount())}")
        }
        println()
    }

    fun printWinners(cars: List<Car>) {
        val counts = mutableListOf<Int>()

        cars.forEach {
            counts.add(it.getMoveCount())
        }
        val maxCount = counts.max()
        val winners = cars.filter {
            it.getMoveCount() == maxCount
        }
        println(FINAL_RESULT.format(winners.joinToString(", ") { it.name }))
    }

    companion object {
        private const val CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val ROUND_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?"
        private const val ROUND_RESULT_MESSAGE = "실행 결과"
        private const val FINAL_RESULT = "최종 우승자: %s"
    }
}
