package generator

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return (RANDOM_LIMIT_MIM_NUM..RANDOM_LIMIT_MAX_NUM).random()
    }

    companion object {
        const val RANDOM_LIMIT_MIM_NUM = 0
        const val RANDOM_LIMIT_MAX_NUM = 9
    }
}
