package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class CarNameParserTest {

    @Test
    fun parse() {
        val parse = CarNameParser.parse("pobi,crong,honux")

        assertThat(parse.size).isEqualTo(3)
    }

    @Test
    internal fun parseNull() {
        assertThatIllegalArgumentException()
            .isThrownBy { CarNameParser.parse(null) }
    }
}