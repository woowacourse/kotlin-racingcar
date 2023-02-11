package generator

import util.Constants

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return (Constants.RANDOM_LIMIT_MIM_NUM..Constants.RANDOM_LIMIT_MAX_NUM).random()
    }
}
