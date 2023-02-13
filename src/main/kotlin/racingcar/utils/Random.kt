package racingcar.utils

object Random {
    fun pickInRange(start: Int, end: Int): Int = (start..end).random()
import kotlin.random.Random

object Random {
    private const val RANDOM_SEED = 10

    private val random = Random(RANDOM_SEED)

    fun pickInRange(start: Int, end: Int) = random.nextInt(start, end + 1)
}
