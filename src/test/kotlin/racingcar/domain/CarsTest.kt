package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    @DisplayName("중복된 이름이 있을 경우 예외를 발생해야 합니다.")
    fun validateDuplicateCarNames() {
        shouldThrow<IllegalArgumentException> {
            Cars(listOf(Car("a"), Car("a"), Car("b")))
        }
    }
}