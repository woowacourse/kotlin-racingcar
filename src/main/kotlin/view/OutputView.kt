package view

import model.Car

object OutputView {

    fun printMessage(message: String) = println(message)
    fun printCar() = println(INPUT_CAR_NAMES_MESSAGE)
    fun printTryCount() = println(INPUT_TRY_COUNT_MESSAGE)
    fun printRunResultMessage() = println("\n$RUN_RESULT_MESSAGE")
    fun printRoundResult(carsInfo: List<Car>) {
        carsInfo.forEach { car ->
            println(car.getPresentStatus())
        }
        println()
    }

    fun printWinners(carsInfo: List<Car>) {
        var output = "$FINAL_WINNERS: "
        carsInfo.forEach { car ->
            output += "${car.name}, "
        }
        print(output.substring(SUBSTRING_START_POSITION, output.length - SUBSTRING_DELETE_COMMA_AND_SPACE))
    }

    private const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    private const val RUN_RESULT_MESSAGE = "실행 결과"
    private const val FINAL_WINNERS = "최종 우승자"
    private const val SUBSTRING_START_POSITION = 0
    private const val SUBSTRING_DELETE_COMMA_AND_SPACE = 2
}
