package racingcar.utils

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

internal class ValidatorTest {

    private lateinit var validator: Validator

    @BeforeEach
    fun beforeEach() {
        this.validator = Validator()
    }

    @ParameterizedTest
    @MethodSource("provideHappyCaseForDuplicatedNames")
    fun `자동차 이름 중복 노말 테스트`(names: List<String>) {
        assertDoesNotThrow {
            validator.checkCarNames(names)
        }
    }

    @ParameterizedTest
    @MethodSource("provideExceptionCaseForDuplicatedNames")
    fun `자동차 이름 중복 예외 테스트`(names: List<String>) {
        assertThrows<IllegalArgumentException> {
            validator.checkCarNames(names)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", Int.MAX_VALUE.toString(), "5", "6"])
    fun `시도 횟수 노말 테스트`(input: String) {
        assertDoesNotThrow {
            validator.checkRoundCount(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", (Int.MAX_VALUE.toLong() + 1).toString(), "-1", "*", "", "otter", "buna"])
    fun `시도 횟수 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            validator.checkRoundCount(input)
        }
    }

    companion object {
        @JvmStatic
        fun provideHappyCaseForDuplicatedNames(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("sooda", "buna")),
                Arguments.of(listOf("sooda", "buna", "soda", "bunaa")),
            )

        @JvmStatic
        fun provideExceptionCaseForDuplicatedNames(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf("soodal", "soodal")),
                Arguments.of(listOf("buna", "buna")),
            )
    }
}
