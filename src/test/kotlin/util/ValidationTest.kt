package util

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class ValidationTest {

    @ParameterizedTest(name = "이름이 {0}면 생성 가능")
    @ValueSource(strings = ["가은,나은,다은", "가나다라마,바사아자차,카타파,하"])
    fun `유효한 자동차 이름 입력 테스트`(carsName: String) {
        assertDoesNotThrow { Validation.carsName(carsName) }
    }

    @ParameterizedTest(name = "이름이 {0}이면 생성 불가능")
    @ValueSource(strings = ["가은", "가나다라마바,가은", "가은,가은,나은"])
    fun `유효하지 않은 자동차 이름 입력 테스트`(carsName: String) {
        assertThrows<IllegalArgumentException> {
            Validation.carsName(carsName)
        }
    }

    @ParameterizedTest(name = "시도횟수가 {0}면 생성 가능")
    @ValueSource(strings = ["1", "2", "3", "100"])
    fun `유효한 시도횟수 입력 테스트`(attemptCount: String) {
        assertDoesNotThrow { Validation.attemptCount(attemptCount) }
    }

    @ParameterizedTest(name = "시도횟수가 {0}이면 생성 불가능")
    @ValueSource(strings = ["-1", "0", "횟수"])
    fun `유효하지 않은 시도횟수 입력 테스트`(attemptCount: String) {
        assertThrows<IllegalArgumentException> {
            Validation.attemptCount(attemptCount)
        }
    }
}
