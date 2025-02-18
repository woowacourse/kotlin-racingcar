import java.util.Random

class RandomGenerator(
    private val start: Int,
    private val end: Int,
) {
    fun createRandomValue(): Int {
        return Random().nextInt(start, end)
    }
}
