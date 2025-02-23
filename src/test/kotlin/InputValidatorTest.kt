package racingcar

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.global.InputValidator.requireCarNames

class InputValidatorTest {
    @Test
    @DisplayName("자동차 이름이 6자 이상인 경우 예외가 발생한다.")
    fun t1() {
        val input = "a,b,123456,c"
        assertThrows<IllegalArgumentException> { requireCarNames(input) }
    }

    @Test
    @DisplayName("자동차 이름이 비어있는 경우 예외가 발생한다.")
    fun t2() {
        val input = "a,,b,c"
        assertThrows<IllegalArgumentException> { requireCarNames(input) }
    }

    @Test
    @DisplayName("자동차 이름에 특수문자가 존재할 경우 예외가 발생한다.")
    fun t3() {
        val input = "@밀러,@메다"
        assertThrows<IllegalArgumentException> { requireCarNames(input) }
    }

    @Test
    @DisplayName("자동차 이름에 중복이 존재할 경우 예외가 발생한다.")
    fun t5() {
        val input = "밀러,밀러,메다"
        assertThrows<IllegalArgumentException> { requireCarNames(input) }
    }

    @Test
    @DisplayName("trim을 적용한 자동차 이름에 중복이 존재할 경우 예외가 발생한다.")
    fun t6() {
        val input = " 밀러 ,밀러     ,메다"
        assertThrows<IllegalArgumentException> { requireCarNames(input) }
    }
}
