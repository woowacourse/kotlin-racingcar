package view

import common.ERROR_MESSAGE_FORMAT
import domain.AdvanceCount
import domain.Car
import domain.GameCars
import domain.RandomMovingStrategy

object InputView {

    fun getGameCars(): GameCars {
        while (true) {
            val cars = getCars()

            kotlin.runCatching { return GameCars(cars.toSet()) }
                .onFailure {
                    println(it.message)
                }
        }
    }

    private fun getCars(): List<Car> {
        while (true) {
            val carNames = readln().split(",").map { it.trim() }

            kotlin.runCatching { return carNames.map { Car(it, RandomMovingStrategy()) } }
                .onFailure {
                    println(it.message)
                }
        }
    }

    fun getAdvanceCount(): AdvanceCount {
        var count = 0

        while (true) {
            count = readAdvanceCount()

            kotlin.runCatching { return AdvanceCount(count) }
                .onFailure { println(it.message) }
        }
    }

    private fun readAdvanceCount(): Int {
        while (true) {
            kotlin.runCatching { return readln().toInt() }
                .onFailure { println(ERROR_MESSAGE_FORMAT.format(NUMBER_FORMAT_ERROR).plus("\n${it.message}")) }
        }
    }
}

private const val NUMBER_FORMAT_ERROR = "Int형으로 변환할 수 있는 숫자로 입력해야 합니다."
