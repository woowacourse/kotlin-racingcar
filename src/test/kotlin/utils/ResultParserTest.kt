package utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResultParserTest {

    @Test
    fun `1 이상의 정수 입력시 수만큼 -로 리턴한다`() {
        assertThat(ResultParser.parseToDash(4)).isEqualTo("----")
    }

    @Test
    fun `0 입력시 빈 문자열을 리턴한다`() {
        assertThat(ResultParser.parseToDash(0)).isEqualTo("")
    }
}