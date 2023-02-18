package racingcar.domain

import racingcar.utils.MAX_CAR_NAME_LENGTH
import racingcar.utils.MIN_CAR_NAME_LENGTH
import racingcar.utils.RacingRuleValidator

class CarName(
    val name: String
) {

    init {
        val validator = RacingRuleValidator()
        require(validator.isValidateCarNameLength(name)) { CAR_NAME_BOUNDARY_ERROR_MESSAGE }
    }

    override fun toString(): String {
        return name
    }

    companion object {
        private const val CAR_NAME_BOUNDARY_ERROR_MESSAGE =
            "자동차 이름의 길이는 $MIN_CAR_NAME_LENGTH 이상 $MAX_CAR_NAME_LENGTH 이하로 부탁이요~"
    }
}
