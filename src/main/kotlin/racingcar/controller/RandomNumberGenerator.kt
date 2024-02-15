package racingcar.controller

import kotlin.random.Random
import kotlin.random.nextInt


class RandomNumberGenerator(private val numberOfCars: Int) {

    fun putRandomNumbers(): List<Int> {
        val randomNumbers: MutableList<Int> = mutableListOf()

        for (index in 0 until numberOfCars) {
            val randomNumber: Int = Random.nextInt(0..9)
            randomNumbers.add(randomNumber)
        }

        return randomNumbers
    }
}
