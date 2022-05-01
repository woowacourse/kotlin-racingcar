package racingcar.domain


class RandomMovingStrategy(private val range: IntRange, private val threshold: Int) : MovingStrategy{

//
//    companion object {
//        const val THRESHOLD = 4
//        const val RANDOM_MIN_VALUE = 0
//        const val RANDOM_MAX_VALUE = 9
//    }

    override fun isMovable(): Boolean {
        return range.random() >= threshold
    }
}