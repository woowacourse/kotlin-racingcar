package model

import kotlin.math.max
import kotlin.random.Random

class RacingGame {
    private lateinit var racingCars: List<Car>

    fun generateCars(rawCars: String) {
        racingCars = rawCars.split(",").map { Car(it.trim()) }

        require(racingCars.size > 1) { INVALID_CAR_SIZE }
        require(racingCars.size == racingCars.distinct().size) { DUPLICATE_CAR_NAME }
    }

    fun tryRacing(rawCount: String): String {
        require(rawCount.toIntOrNull() != null) { INVALID_COUNT }
        require(rawCount.toInt() > 0) { NEGATIVE_COUNT }
        var result = "실행 결과"

        repeat(rawCount.toInt()) {
            racingCars.forEach {
                it.tryForward(getRandomValue())
                result += "\n${it.getName()} : ${it.getStep()}"
            }
            result += "\n"
        }
        return result
    }

    private fun getRandomValue(): Int = Random.nextInt(0, 9)

    fun calculateWinner(): String {
        val maxValue = racingCars.maxOfOrNull { it.getStep().length }
        return racingCars.filter { it.getStep().length == maxValue }.map{it.getName()}.joinToString(", ")
    }

    private companion object {
        const val INVALID_CAR_SIZE = "레이싱 게임은 두대 이상이어야 합니다."
        const val DUPLICATE_CAR_NAME = "자동차 이름이 중복됩니다."
        const val INVALID_COUNT = "숫자가 아닙니다."
        const val NEGATIVE_COUNT = "횟수는 양수여야 합니다."
    }
}