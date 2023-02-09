package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import util.DriverDecision
import util.TestNumberGenerator

class DriverTest {

    @CsvSource(value = ["1,STOP", "2,STOP", "3,STOP", "4,GO"])
    @ParameterizedTest
    fun `전진할지 정지할지 판단하는 기능 테스트`(randomNum: Int, expectedResult: DriverDecision) {
        // given
        val driver = Driver(TestNumberGenerator(randomNum))

        // when
        val actualResult: DriverDecision = driver.decideMovement()

        // then
        assertThat(actualResult).isEqualTo(expectedResult)
    }
}
