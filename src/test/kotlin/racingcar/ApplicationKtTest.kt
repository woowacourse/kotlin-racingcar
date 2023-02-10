package racingcar

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayInputStream
import java.util.stream.Stream

internal class ApplicationKtTest {

    @ParameterizedTest
    @MethodSource("provideInputNormalCases")
    fun `전체 기능 노말 테스트`(carNames: String, roundCount: String) {
        setInput(carNames, roundCount)
        assertDoesNotThrow {
            main()
        }
    }

    @ParameterizedTest
    @MethodSource("provideInputExceptionCases")
    fun `전체 기능 예외 테스트`(carNames: String, roundCount: String) {
        setInput(carNames, roundCount)
        assertThrows<IllegalArgumentException> {
            main()
        }
    }

    private fun setInput(carNames: String, roundCount: String) {
        val input = ByteArrayInputStream("$carNames\n$roundCount".toByteArray())
        System.setIn(input)
    }

    companion object {

        @JvmStatic
        fun provideInputNormalCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("otter,buna", "6"),
                Arguments.of("otter, buna", "1"),
                Arguments.of("otter", "${Int.MAX_VALUE}"),
                Arguments.of("buna", "1"),
                Arguments.of("otter,buna,스캇,핑구,써니,우기,아따맘마,말파이트", "1"),
            )
        }

        @JvmStatic
        fun provideInputExceptionCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("otter123,buna", "6"),
                Arguments.of("otter,buna", "${Int.MAX_VALUE.toLong() + 1}"),
                Arguments.of("otter,buna", "-1"),
                Arguments.of(" ", "2"),
                Arguments.of("", "2"),
                Arguments.of(",,,,,,", "3"),
                Arguments.of("buna,buna,  buna", "3"),
            )
        }
    }
}