package racingcar.ui

import racingcar.domain.Car

private const val ROUND_RESULT = "실행 결과"
private const val WINNER_MESSAGE = "가 최종 우승했습니다."

fun printRoundResultMessage() {
    println(ROUND_RESULT)
}

fun printErrorMessage(error: String?) {
    println(error)
}

fun printRoundResult(cars: List<Car>) {
    cars.forEach {
        car -> printCarPositionInfo(car)
    }
    println()
}

private fun printCarPositionInfo(car: Car) {
    println("${car.name} : ${"-".repeat(car.position)}")
}

fun printWinners(winners: List<Car>) {
    println("${getWinnerNames(winners)} $WINNER_MESSAGE")
}

fun getWinnerNames(winners: List<Car>): String{
    return winners.joinToString(separator = ", ") { winner -> winner.name }
}