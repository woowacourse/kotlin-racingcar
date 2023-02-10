package generator

class RandomGenerator {

    fun getRandomNumber(): Int {
        return (MIN..MAX).random()
    }

    companion object {
        const val MIN = 0
        const val MAX = 9
    }
}
