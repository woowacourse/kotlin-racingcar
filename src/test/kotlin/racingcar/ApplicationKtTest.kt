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
    fun `1글자 이상 5글자 이하의 중복되지 않은 이름과 1이상 Int 최대값 이하의 라운드 횟수가 주어졌을 때, 자동차 경주를 시작하면, 예외가 발생하지 않는다`(
        carNames: String,
        roundCount: String
    ) {
        setInput(carNames, roundCount)
        assertDoesNotThrow {
            main()
        }
    }

    @ParameterizedTest
    @MethodSource("provideDuplicatedNameCases")
    fun `중복된 이름이 주어졌을 때, 자동차 경주를 시작하면, IllegalArgumentException 예외가 발생한다`(carNames: String, roundCount: String) {
        setInput(carNames, roundCount)
        assertThrows<IllegalArgumentException> {
            main()
        }
    }

    @ParameterizedTest
    @MethodSource("provideOutOfNameLengthCases")
    fun `길이가 1글자 미만 또는 5글자 초과한 이름이 주어졌을 때, 자동차 경주를 시작하면, IllegalArgumentException 예외가 발생한다`(
        carNames: String,
        roundCount: String
    ) {
        setInput(carNames, roundCount)
        assertThrows<IllegalArgumentException> {
            main()
        }
    }

    @ParameterizedTest
    @MethodSource("provideOutOfRoundCases")
    fun `1미만 Int 최대값 초과한 라운드 횟수가 주어졌을 때, 자동차 경주를 시작하면, IllegalArgumentException 예외가 발생한다`(
        carNames: String,
        roundCount: String
    ) {
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
                Arguments.of("buna", "1"),
                Arguments.of("otter,buna,스캇,핑구,써니,우기,아따맘마,말파이트", "1"),
            )
        }

        @JvmStatic
        fun provideDuplicatedNameCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("buna,buna,  buna", "3"),
                Arguments.of("otter,otter,buna", "3"),
            )
        }

        @JvmStatic
        fun provideOutOfNameLengthCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("otter123,buna, buna", "3"),
                Arguments.of("", "2"),
            )
        }

        @JvmStatic
        fun provideOutOfRoundCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("otter, buna", "${Int.MAX_VALUE.toLong() + 1}"),
                Arguments.of("otter, buna", "-1"),
            )
        }
    }
}
