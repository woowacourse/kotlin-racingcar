package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Racecourse
import racingcar.domain.RoundManager
import racingcar.util.ErrorMessage
import racingcar.util.extension.times

class View {
    fun playRacingGame() {
        val cars: List<Car> = readCars()
        val roundManager: RoundManager = readRound()
        showResult(cars, roundManager)
    }

    private fun readCars(): List<Car> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        runCatching {
            val userInput: String =
                readlnOrNull() ?: throw IllegalArgumentException(ErrorMessage.FAIL_TO_READ_INPUT)
            Car.Companion.createCars(userInput)
        }.onSuccess { cars: List<Car> ->
            return cars
        }.onFailure { error: Throwable ->
            println(error.message)
            return readCars()
        }

        throw IllegalStateException(ErrorMessage.RUNCATCHING_NO_RESULT)
    }

    private fun readRound(): RoundManager {
        println("시도할 횟수는 몇 회인가요?")

        runCatching {
            val userInput: String =
                readlnOrNull() ?: throw IllegalStateException(ErrorMessage.FAIL_TO_READ_INPUT)
            RoundManager.Companion.from(userInput)
        }.onSuccess { roundManager: RoundManager ->
            return roundManager
        }.onFailure { error: Throwable ->
            println(error.message)
            return readRound()
        }

        throw IllegalStateException(ErrorMessage.RUNCATCHING_NO_RESULT)
    }

    private fun showResult(
        cars: List<Car>,
        roundManager: RoundManager,
    ) {
        println("\n실행결과")
        val racecourse = Racecourse(cars, roundManager)
        racecourse.startRace(onEachRound = {
            cars.forEach { car: Car -> println("${car.name} : ${"-" * (car.distance)}") }
            println()
        })
        print("최종 우승자: ${racecourse.winners.joinToString { car: Car -> car.name }}")
    }
}
