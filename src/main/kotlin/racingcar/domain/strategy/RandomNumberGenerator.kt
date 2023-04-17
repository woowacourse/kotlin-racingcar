package racingcar.domain.strategy

class RandomNumberGenerator : NumberGenerator {

    override fun generate(): Int {
        return (0..9).random()
    }
}
