package racingcar.view

import racingcar.model.Car

object OutputView {
    fun outputStartGame() {
        println()
        println(RESULT_START)
    }

    fun outputRegisterCar() {
        println(REGISTER_CAR_NAMES)
    }

    fun outputRegisterNumberOfRoundRound() {
        println(NUMBER_OF_ROUND)
    }

    fun outputRoundResults(cars: List<Car>) {
        cars.forEach { car ->
            println(ROUND_RESULT.format(car.getName(), PROGRESS_BAR.repeat(car.getStep())))
        }
        println()
    }

    fun outputWinners(winners: List<String>) {
        println(FINAL_WINNERS.format(winners.joinToString(SEPARATOR)))
    }

    private const val PROGRESS_BAR = "-"
    private const val SEPARATOR = ", "
    private const val RESULT_START = "실행 결과"
    private const val ROUND_RESULT = "%s : %s"
    private const val FINAL_WINNERS = "최종 우승자: %s"
    private const val REGISTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val NUMBER_OF_ROUND = "시도할 횟수는 몇 회인가요?"
}
