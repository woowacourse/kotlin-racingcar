package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun initCar() {
        car = Car("Tom", INITIAL_MOVE_COUNT)
    }

    @Test
    fun `이름이 5자를 넘으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Car("aaaaaa")
        }
    }

    @Test
    fun `이름이 비어있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Car(" ")
        }
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `값이 4 이상인 경우 이동한다`(number: Int) {
        car.tryMove(TestNumberGenerator(number).generate())
        assertThat(car.moveCount).isEqualTo(EXPECTED_MOVE_COUNT)
        println(car.moveCount)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `값이 3 이하인 경우 이동하지 않는다`(number: Int) {
        car.tryMove(TestNumberGenerator(number).generate())
        assertThat(car.moveCount).isEqualTo(INITIAL_MOVE_COUNT)
    }

    companion object {
        private const val INITIAL_MOVE_COUNT = 0
        private const val EXPECTED_MOVE_COUNT = 1
    }
}

class TestNumberGenerator(private val number: Int) : CarNumberGenerator {
    override fun generate(): Int {
        return number
    }
}
