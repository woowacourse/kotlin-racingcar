import kotlin.random.Random

class TryMoveNumber : NumberGenerator {
    override fun generate(): Int = Random.nextInt(MOVE_NUMBER_FROM, MOVE_NUMBER_TO)

    companion object {
        const val MOVE_NUMBER_FROM = 4
        const val MOVE_NUMBER_TO = 10
    }
}
