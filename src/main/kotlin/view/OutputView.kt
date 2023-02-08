package view

import domain.Car

class OutputView {

    fun printCarNamesPrompt() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printRoundCountPrompt() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printRoundResultMessage() {
        println("실행 결과")
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
        println("최종 우승자: ${winners.joinToString(", ") { it.name }}")
    }
}
