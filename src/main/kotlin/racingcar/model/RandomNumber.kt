package racingcar.model

import java.util.Random

object RandomNumber : NumberGenerator {
    override fun generate(): Int = Random().nextInt(10)
}
