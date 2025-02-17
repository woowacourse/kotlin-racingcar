package ui

import domain.Car

class OutputPrinter {
    fun printRaceCarNamesGuide() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printRaceCountGuide() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printRaceResultTitle() {
        println("\n실행 결과")
    }

    fun printRaceProgress(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${RACE_CAR_POSITION_INDICATOR.repeat(car.position)}")
        }
        println()
    }

    fun printWinners(winnerNames: List<String>) {
        println("최종 우승자: ${winnerNames.joinToString(RACE_WINNER_NAMES_DIVIDER)}")
    }

    companion object {
        private const val RACE_CAR_POSITION_INDICATOR = "-"
        private const val RACE_WINNER_NAMES_DIVIDER = ", "
    }
}
