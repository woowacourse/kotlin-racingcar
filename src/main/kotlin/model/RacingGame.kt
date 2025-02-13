package model

import kotlin.random.Random

class RacingGame {
    private lateinit var racingCars: List<Car>

    fun generateCars(rawCars: String) {
        racingCars = rawCars.split(",").map { Car(it.trim()) }

        require(racingCars.size > 1) { INVALID_CAR_SIZE }
        require(racingCars.size == racingCars.distinct().size) { DUPLICATE_CAR_NAME }
    }

    fun tryRacing(rawCount: String): String {
        require(rawCount.toIntOrNull()?.let { it > 0 } == true) { INVALID_COUNT }
        val result = StringBuilder("실행 결과")

        repeat(rawCount.toInt()) {
            racingCars.forEach {
                it.tryForward(getRandomValue())
                result.append("\n${it.getName()} : ${it.getStep()}")
            }
            result.append("\n")
        }
        return result.toString()
    }

    private fun getRandomValue(): Int = Random.nextInt(0, 9)

    fun calculateWinner(): String {
        val maxValue = racingCars.maxOfOrNull { it.getStep().length }
        return racingCars.filter { it.getStep().length == maxValue }.map { it.getName() }.joinToString(", ")
    }

    private companion object {
        const val INVALID_CAR_SIZE = "레이싱 게임은 두대 이상이어야 합니다."
        const val DUPLICATE_CAR_NAME = "자동차 이름이 중복됩니다."
        const val INVALID_COUNT = "시도할 횟수는 자연수여야 합니다."
    }
}
