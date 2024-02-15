package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MoveOrStayTest {
    private lateinit var moveOrStay: MoveOrStay

    @BeforeEach
    fun setUp() {
        moveOrStay = MoveOrStay()
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤 숫자가 4 ~ 9이면 true(이동)인지`(input: Int) {
        val result = moveOrStay.decideMovement(input)
        assertThat(result).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [0,1,2,3])
    fun `랜덤 숫자가 0 ~ 3이면 false(정지)인지`(input: Int) {
        val result = moveOrStay.decideMovement(input)
        assertThat(result).isFalse()
    }
}