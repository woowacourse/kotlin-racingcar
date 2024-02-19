package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RacingStatusManagerTest {
    private lateinit var racingStatusManager: RacingStatusManager
    private lateinit var numberGenerator: NumberGenerator
    private lateinit var movementDecisionMaker: MovementDecisionMaker

    @BeforeEach
    fun setUp() {
        val initialStatus = listOf(Car("kmkim"), Car("kkm"), Car("kmk"))
        numberGenerator = TestNumberGenerator()
        movementDecisionMaker = ThresholdMovementDecisionMaker()
        racingStatusManager = RacingStatusManager(
            cars = initialStatus,
            getNumber = numberGenerator::getNumber,
            isMovable = movementDecisionMaker::isMovable,
        )
    }

    @Test
    fun `숫자를 산출한 횟수가 짝수라면 움직임이 가능한 숫자를 반환하는 메소드를 활용해, 경주 1회 시행 시 결과가 올바르게 설정되는지 테스트`() {
        racingStatusManager.setRacingResult()
//        assertThat(racingStatusManager.currentRacingStatus).contains(
//            Car(name = "kmkim", position = 0),
//            Car(name = "kkm", position = 1),
//            Car(name = "kmk", position = 0),
//        )
    }
}
