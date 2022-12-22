package domain

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int = (0..9).random()
}
