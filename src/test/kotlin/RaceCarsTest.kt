import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RaceCarsTest {
    @Test
    fun `차는 중복될 수 없습니다`() {
        assertThrows<IllegalArgumentException>("차는 중복될 수 없습니다.") {
            RaceCars(listOf(RaceCar("foo"), RaceCar("foo")), { 1 })
        }
    }

    @Test
    fun `차 리스트는 비어 있으면 안된다`() {
        assertThrows<IllegalArgumentException>("차 리스트는 비어 있으면 안된다.") {
            RaceCars(emptyList(), { 1 })
        }
    }

    @Test
    fun `이름 리스트로 RaceCars 를 생성할 수 있다`() {
        // given
        val expectedRaceCars = RaceCars(listOf(RaceCar("foo"), RaceCar("bar")), { 1 })
        // when
        val actualRaceCars = RaceCars.from(listOf("foo", "bar"), { 1 })
        // then
        assertThat(actualRaceCars).isEqualTo(expectedRaceCars)
    }

    @Test
    fun `가장 선두 주자에 있는 차들을 찾을 수 있다`() {
        // given
        val headCar = RaceCar("foo").apply { move(5) }
        val headCar2 = RaceCar("bar").apply { move(6) }
        val car = RaceCar("june").apply { move(4) }
        val raceCars = RaceCars(listOf(headCar, headCar2, car), { 2 })
        val expectedHeadGroup = listOf(headCar, headCar2)
        // when
        val headCarGroup = raceCars.findHeadGroup()
        // then
        assertThat(headCarGroup).isEqualTo(expectedHeadGroup)
    }
}
