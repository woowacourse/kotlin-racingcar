package generator

import util.Constants

class RandomGenerator : NumberGenerator {
    override fun generateNumber(): Int {
        return (Constants.RANDOM_LIMIT_MIM_NUM..Constants.RANDOM_LIMIT_MAX_NUM).random()
    }
}
