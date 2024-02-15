package racingcar.controller

import racingcar.model.Ranges
import kotlin.random.Random
import kotlin.random.nextInt

class RandomNumberGenerator(private val numberOfCars: Int) {
    fun putRandomNumbers(): List<Int> {
        val randomNumbers: MutableList<Int> = mutableListOf()

        for (index in 0 until numberOfCars) {
            val randomNumber: Int = Random.nextInt(Ranges.randomNumber)
            randomNumbers.add(randomNumber)
        }
        return randomNumbers
    }
}
