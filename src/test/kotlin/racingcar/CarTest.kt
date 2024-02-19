package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car
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

    @Test
    fun checkDontMove() {
        for(i in MIN_STOP_NUMBER..MAX_STOP_NUMBER) {
            assertThat(Car("test").move(i) == CONDITION_STOP)
        }
    }

    @Test
    fun checkMoveForward() {
        for(i in MIN_MOVE_NUMBER..MAX_MOVE_NUMBER) {
            assertThat(Car("test").move(i) == CONDITION_MOVE)
        }
    }

    companion object {
        private const val MIN_STOP_NUMBER = 0
        private const val MAX_STOP_NUMBER = 4
        private const val MIN_MOVE_NUMBER = 5
        private const val MAX_MOVE_NUMBER = 9

        private const val CONDITION_STOP = 0
        private const val CONDITION_MOVE = 1
    }
}
