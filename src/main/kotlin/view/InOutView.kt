package view

import data.Car

enum class InOutConstant(val constant: String) {
    NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    COUNT("시도할 횟수는 몇 회인가요?"),
    CURRENT_RESULT_FORMAT("%s : %s"),
    GAME_RESULT("\n실행 결과"),
    FINAL_RESULT("최종 우승자 : "),
}

class InOutView {
    fun getData(data: InOutConstant): String {
        println(data.constant)
        return readln()
    }

    fun printCurrentResult(car: Car) {
        println(InOutConstant.CURRENT_RESULT_FORMAT.constant.format(car.name, "-".repeat(car.currentPosition)))
    }

    fun printGameResult() {
        println(InOutConstant.GAME_RESULT.constant)
    }

    fun printFinalResult(winnerList: MutableList<Car>) {
        print(InOutConstant.FINAL_RESULT.constant)
        println(winnerList.joinToString(", ") { it.name })
    }
}
