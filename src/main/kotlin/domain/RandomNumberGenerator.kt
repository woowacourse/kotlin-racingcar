package domain

class RandomNumberGenerator : CarNumberGenerator {
    override fun generate() = (0..9).random()
}
