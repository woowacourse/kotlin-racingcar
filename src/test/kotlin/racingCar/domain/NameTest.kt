package racingCar.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class NameTest {

    @Test
    @DisplayName("빈 값이 들어갈 수 없다")
    fun notEmpty() {
        assertThrows<IllegalArgumentException>{Name("")}
    }

    @Test
    @DisplayName("6자리 이상 들어갈 수 없다")
    fun overSize() {
        assertThrows<IllegalArgumentException>{Name("pepper")}
    }
}
