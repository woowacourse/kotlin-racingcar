import kotlin.random.Random

class TryMoveNumberGenerator : TryMoveNumberStrategy {
    override fun getNumber() = Random.nextInt(TRY_NUMBER_UNTIL)

    companion object {
        const val TRY_NUMBER_UNTIL = 10
    }
}
