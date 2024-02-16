package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MoveManagerTest {
    private lateinit var moveManager: MoveManager

    @BeforeEach
    fun setup() {
        moveManager = MoveManager()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `정지 최댓값보다 작거나 같은 뽑힌 경우 false 반환`(num: Int) {
        assertThat(moveManager.isMoveAble(num)).isFalse()
    }


    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `전진을 위한 최솟값보다 크거나 같은 값이 뽑힌 경우 true 반환`() {
        val num = 4
        assertThat(moveManager.isMoveAble(num)).isTrue()
    }
}