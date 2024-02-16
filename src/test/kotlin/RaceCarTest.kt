import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RaceCarTest {
    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        assertThrows<IllegalArgumentException>("자동차 이름은 5자를 초과할 수 없다.") {
            RaceCar("foobar")
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 10])
    fun `score가 5 ~ 9 범위 밖일 때 멈춘다`(score: Int) {
        // given
        val raceCar = RaceCar("foo")
        raceCar.moveOrStop(score)
        // then
        assertEquals(raceCar.toString(), "foo : ")
    }

    @ParameterizedTest
    @ValueSource(ints = [5, 6, 7, 8, 9])
    fun `score가 5 ~ 9 범위 안일 때 전진한다`(score: Int) {
        // given
        val raceCar = RaceCar("foo")
        raceCar.moveOrStop(score)
        // then
        assertEquals(raceCar.toString(), "foo : -")
    }
}
