package racingcar

import racingcar.domain.Configure.Companion.RANDOM_SEED
import kotlin.random.Random

class Random : RandomGenerator {
    private val random = Random(RANDOM_SEED)

    override fun nextInt(
        from: Int,
        until: Int,
    ): Int = random.nextInt(from, until)
}
