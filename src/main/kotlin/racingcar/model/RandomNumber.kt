package racingcar.model

import java.util.Random

object RandomNumber {
    fun generate(): Int {
        return Random().nextInt(10)
    }
}
