package randomutils

object RandomGenerator {
    private const val START_NUMBER: Int = 1
    private const val END_NUMBER: Int = 9

    fun generateRandom(): Int {
        return (START_NUMBER..END_NUMBER).shuffled().first()
    }
}
