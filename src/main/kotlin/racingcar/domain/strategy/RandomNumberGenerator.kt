package racingcar.domain.strategy

private const val MINIMUM_NUMBER = 0
private const val MAXIMUM_NUMBER = 9

class RandomNumberGenerator : NumberGenerator {

    override fun generate(): Int {
        return (MINIMUM_NUMBER..MAXIMUM_NUMBER).random()
    }
}
