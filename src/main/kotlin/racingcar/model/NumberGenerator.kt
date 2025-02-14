package racingcar.model

interface NumberGenerator {
    fun generate(
        min: Int,
        max: Int,
    ): Int
}
