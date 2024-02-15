package domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class CarsTest {
    @Test
    fun `중복된 자동차 이름 검증`() {
        assertThatThrownBy {
            Cars.from("aa,bb,aa", RandomNumberGenerator())
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("중복된 이름이 존재합니다.")
    }

    @Test
    fun `자동차 이름에 중복이 없을 시 성공`() {
        assertDoesNotThrow {
            Cars.from("aa,bb,cc", RandomNumberGenerator())
        }
    }
}