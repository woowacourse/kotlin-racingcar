package racingcar

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @DisplayName("생성 시 공백이 존재하면 에러가 발생한다.")
    @Test
    fun nameSpaceException() {
        assertThrows<IllegalArgumentException> {
            Car(" huni")
        }
    }
}
