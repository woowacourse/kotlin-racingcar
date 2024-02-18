package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.validator.Validation

class CarTest {
    @Test
    fun inputIsEmpty() {
        assertThrows<IllegalArgumentException> {
            Validation().carName("")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "crongcrong"])
    fun outOfRangeNameLength(name: String) {
        assertThrows<IllegalArgumentException> {
            Validation().carName(name)
        }
    }

    @Test
    fun inputContainsSpace() {
        assertThrows<IllegalArgumentException> {
            Validation().carName("he na")
        }
    }
}
