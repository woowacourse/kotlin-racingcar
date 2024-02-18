package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car

class CarTest {
    @Test
    fun inputIsEmpty() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "crongcrong"])
    fun outOfRangeNameLength(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    @Test
    fun inputContainsSpace() {
        assertThrows<IllegalArgumentException> {
            Car("he na")
        }
    }
}
