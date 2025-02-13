package model

interface RandomNumberGenerator {
    fun generate(
        min: Int,
        max: Int,
    ): Int
}
