package racingCar.domain

class FixedNumberGenerator(private val numbers: Int) : NumberGenerator {

    override fun generate(): Int {
        return numbers
    }
}
