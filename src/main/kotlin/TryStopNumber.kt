import kotlin.random.Random

class TryStopNumber : NumberGenerator {
    override fun generate(): Int = Random.nextInt(STOP_NUMBER_UNTIL)

    companion object {
        const val STOP_NUMBER_UNTIL = 4
    }
}
