import kotlin.random.Random

class TryStopNumber : NumberGenerator {
    override fun generate(): Int = Random.nextInt(0, 4)
}
