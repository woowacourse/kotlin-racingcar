import kotlin.random.Random

class TryMoveNumber : NumberGenerator {
    override fun generate(): Int = Random.nextInt(4, 10)
}
