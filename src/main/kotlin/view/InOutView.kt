package view

import model.Car

object InOutConstants {
    const val NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    const val COUNT = "시도할 횟수는 몇 회인가요?"
    const val CURRENT_RESULT_FORMAT = "%s : %s"
    const val GAME_RESULT = "\n실행 결과"
    const val FINAL_RESULT = "최종 우승자 : "
}

class InOutView {
    fun getData(message: String): String {
        println(message)
        return readln()
    }

    fun printCurrentResult(car: Car) {
        println(InOutConstants.CURRENT_RESULT_FORMAT.format(car.name, "-".repeat(car.currentPosition)))
    }

    fun printGameResult() {
        println(InOutConstants.GAME_RESULT)
    }

    fun printFinalResult(winnerList: List<Car>) {
        print(InOutConstants.FINAL_RESULT)
        println(winnerList.joinToString(", ") { it.name })
    }
}
