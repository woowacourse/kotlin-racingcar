package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.constants.Constants.MOVE_THRESHOLD

class MoveManagerWithMinimumTest {
    private lateinit var moveManager: MoveManagerWithMinNum

    @BeforeEach
    fun setup() {
        moveManager = MoveManagerWithMinNum(MOVE_THRESHOLD)
    }

    @Test
    fun `4 미만의 정수가 뽑혔을 경우 false를 반환`() {
        val num = 3
        assertThat(moveManager.isMoveAble(num)).isFalse()
    }

    @Test
    fun `4 이상의 정수가 뽑혔을 경우 true를 반환`() {
        val num = 4
        assertThat(moveManager.isMoveAble(num)).isTrue()
    }
}
