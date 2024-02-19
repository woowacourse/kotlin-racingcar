package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.constants.Constants

class RacingStatusManagerTest {
    private lateinit var racingStatusManager: RacingStatusManager
    private lateinit var numberGenerator: NumberGenerator
    private lateinit var movementDecisionMaker: MovementDecisionMaker

    @BeforeEach
    fun setUp() {
        val initialStatus = listOf(Car("kmkim"), Car("kkm"), Car("kmk"))
        numberGenerator = NumberGenerator(object : PickingStrategy {
            override fun pickNumber(): Int {
                return 5
            }
        })
        movementDecisionMaker = ThresholdMovementDecisionMaker()
        racingStatusManager = RacingStatusManager(
            cars = initialStatus,
            getNumber = numberGenerator::getNumber,
            isMovable = movementDecisionMaker::isMovable,
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 0])
    fun `숫자를 산출한 횟수가 짝수라면 움직임이 가능한 숫자를 반환하는 메소드를 활용해, 경주 1회 시행 시 결과가 올바르게 설정되는지 테스트`(targetNum: Int) {
        racingStatusManager.getRacingStatus()
        racingStatusManager.currentRacingStatus.onEach {
            assertThat(it.position).isEqualTo(targetNum)
        }
    }
}
