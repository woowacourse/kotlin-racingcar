import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `숫자가 4 이상이면 전진한다 `() {
        // given
        val car = Car("포비")
        val expected = 1

        // when
        car.moveOrStop(TestMoveNumberGenerator())

        // then
        Assertions.assertThat(car.getDistance()).isEqualTo(expected)
    }

    @Test
    fun `숫자가 4 미만이면 전진하지 않는다`() {
        val car = Car("포비")
        val expected = 0

        car.moveOrStop(TestStopNumberGenerator())

        Assertions.assertThat(car.getDistance()).isEqualTo(expected)
    }

    @Test
    fun `숫자가 4 이상이면 전진하고 위치를 출력한다`() {
        val car = Car("포비")
        val expected = "포비 : -"

        car.moveOrStop(TestMoveNumberGenerator())

        Assertions.assertThat(car.toString()).isEqualTo(expected)
    }

    @Test
    fun `숫자가 4 미만이면 전진하지 않고 위치를 출력한다`() {
        val car = Car("포비")
        val expected = "포비 : "

        car.moveOrStop(TestStopNumberGenerator())

        Assertions.assertThat(car.toString()).isEqualTo(expected)
    }
}

class TestMoveNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return 4
    }
}

class TestStopNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return 1
    }
}
