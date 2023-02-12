package dto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RaceTimeDTOTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "5", "10"])
    fun `경주 시도 횟수가 올바르면 에러가 발생하지 않는다`(input: String) {
        Assertions.assertDoesNotThrow { RaceTimeDTO(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi", "", "가나초콜릿"])
    fun `경주 시도 횟수가 숫자가 아니면 에러가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { RaceTimeDTO(input) }
        org.assertj.core.api.Assertions.assertThat(exception.message).isEqualTo(RaceTimeDTO.ERROR_NOT_INTEGER)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "11"])
    fun `경주 시도 횟수가 1이상 10이하가 아니면 에러가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { RaceTimeDTO(input) }
        org.assertj.core.api.Assertions.assertThat(exception.message).isEqualTo(RaceTimeDTO.ERROR_NOT_IN_RANGE)
    }
}
