import kotlin.random.Random

class RandomNumber : NumberGenerator {
    override fun generate(): Int = Random.nextInt(TRY_NUMBER_UNTIL)

    companion object {
        const val TRY_NUMBER_UNTIL = 10
    }
}
