package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `자동차 이름을 5글자 초과로 설정 - 에러 발생`() {
        assertThrows<IllegalArgumentException> { Car("racing") }
    }

    @Test
    fun `자동차 이름을 5글자 이하로 설정 - 정상 작동`() {
        assertDoesNotThrow { Car("yenny") }
    }

    @Test
    fun `자동차 이동 테스트 - 성공`() {
        val myCar = Car("eddy")
        myCar.move(1)
        assertThat(myCar.distance).isEqualTo(1)
    }

    @Test
    fun `자동차 이동 테스트 - 실패`() {
        val myCar = Car("eddy")
        myCar.move(1)
        assertThat(myCar.distance).isNotEqualTo(0)
    }

    @Test
    fun `자동차 상태 출력 테스트 - 움직였을 경우`() {
        val myCar = Car("yenny")
        myCar.move(3)

        val expected = "yenny : ---"
        assertThat(myCar.toString()).isEqualTo(expected)
    }

    @Test
    fun `자동차 상태 출력 테스트 - 움직이지 않은 경우`() {
        val myCar = Car("yenny")

        val expected = "yenny : "
        assertThat(myCar.toString()).isEqualTo(expected)
    }
}
