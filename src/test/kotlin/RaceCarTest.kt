import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class RaceCarTest {

    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        assertThrows<IllegalArgumentException>("자동차 이름은 5자를 초과할 수 없다.") {
            RaceCar("foobar")
        }
    }

    @Test
    fun `score가 5 ~ 9 일 때만 전진한다`() {
        // given
        val raceCar = RaceCar("foo")
        //then
        assertAll(
            { assertThat(raceCar.moveOrStop(4)).isFalse() },
            { assertThat(raceCar.moveOrStop(10)).isFalse() },
            { assertThat(raceCar.moveOrStop(6)).isTrue() }
        )
    }
}