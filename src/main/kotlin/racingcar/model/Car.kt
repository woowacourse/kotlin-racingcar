package racingcar.model

import racingcar.util.Constant
import kotlin.random.Random

class Car(
    private val name: String
) {
    private var step: Int = 0

    fun makeRandomNumber(): Int {
        return Random.nextInt(Constant.MIN_RANDOM_NUMBER, Constant.MAX_RANDOM_NUMBER)
    }

    fun moveCar() {
        step += 1
    }

    fun getName(): String = name

    fun getStep(): Int = step
}
