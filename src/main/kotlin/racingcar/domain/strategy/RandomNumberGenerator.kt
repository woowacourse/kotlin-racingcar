package racingcar.domain.strategy

class RandomNumberGenerator : NumberGenerator {

    override fun generate(): Int {
        return (MINIMUM_NUMBER..MAXIMUM_NUMBER).random()
    }
}
