package model

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import racingCar.constant.RacingCarRule
import racingCar.model.CarMovementPolicy

class CarMovementPolicyTest {
    @RepeatedTest(1000)
    @DisplayName("생성된 난수는 0 이상 9 이하의 자연수여야 한다.")
    fun carMovementPolicyNumberRangeTest() {
        val generator = CarMovementPolicy(RacingCarRule.RANDOM_MAX_VALUE.value)
        val randomNumber = generator.generate()
        assertTrue(randomNumber in RacingCarRule.RANDOM_MIN_VALUE.value..RacingCarRule.RANDOM_MAX_VALUE.value)
    }
}
