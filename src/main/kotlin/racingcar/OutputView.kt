package racingcar

class OutputView {
    fun printMessage(message: String) {
        println(message)
    }

    fun stepResult(cars: List<Car>) {
        for (car in cars) {
            println(car.toString())
        }
        println()
    }

    fun winner(winners: List<Car>) {
        print("최종 우승자: ")
        var formattedString = StringBuilder()

        for (i in winners.indices) {
            formatWinner(winners, i, formattedString)
        }

        println(formattedString.toString())
    }

    fun formatWinner(winners: List<Car>, index: Int, formattedString: StringBuilder) {
        formattedString.append(winners[index].getName())
        if (index < winners.size - 1)
            formattedString.append(", ")
    }

    companion object {
        const val MSG_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n"
        const val MSG_INPUT_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?"
        const val MSG_STEP_RESULT = "실행 결과"
    }
}
