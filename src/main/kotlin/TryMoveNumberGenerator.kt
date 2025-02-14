import kotlin.random.Random

class TryMoveNumberGenerator : NumberStrategy {
    override fun getNumber() = Random.nextInt(TRY_NUMBER_UNTIL)
}
