package racingcar.view

import racingcar.Car
import racingcar.Racecourse
import racingcar.util.ErrorMessage

class View {
    fun readCars(): List<Car> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        runCatching {
            val userInput: String =
                readlnOrNull() ?: throw IllegalArgumentException(ErrorMessage.FAIL_TO_READ_INPUT)
            Car.createCars(userInput)
        }.onSuccess { cars: List<Car> ->
            return cars
        }.onFailure { error: Throwable ->
            println(error.message)
            return readCars()
        }

        throw IllegalStateException(ErrorMessage.RUNCATCHING_NO_RESULT)
    }

    fun readRound(): Int {
        println("시도할 횟수는 몇 회인가요?")

        runCatching {
            val userInput: String =
                readlnOrNull() ?: throw IllegalStateException(ErrorMessage.FAIL_TO_READ_INPUT)
            parseToRound(userInput)
        }.onSuccess { round: Int ->
            return round
        }.onFailure { error: Throwable ->
            println(error.message)
            return readRound()
        }

        throw IllegalStateException(ErrorMessage.RUNCATCHING_NO_RESULT)
    }

    fun parseToRound(value: String): Int {
        require(value.toIntOrNull() != null && value.toInt() > 0) {
            ErrorMessage.INVALID_ROUND
        }

        return value.toInt()
    }

    fun showResult(
        cars: List<Car>,
        round: Int,
    ) {
        println("\n실행결과")
        val racecourse = Racecourse(cars, round)
        racecourse.startRace()
        println("최종 우승자: ${racecourse.winners.joinToString { car: Car -> car.name }}")
    }
}
