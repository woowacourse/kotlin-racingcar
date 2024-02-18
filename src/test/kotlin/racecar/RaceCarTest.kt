package racecar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import racecar.domain.RaceCar

class RaceCarTest {
    @Test
    fun `자동차 이름과 position이 같으면 같은 자동차이다`() {
        // given
        val raceCar1 = RaceCar("foo", 2)
        val raceCar2 = RaceCar("foo", 2)
        // then
        assertThat(raceCar1).isEqualTo(raceCar2)
    }

    @Test
    fun `자동차 이름은 whiteSpace 를 포함할 수 없다`() {
        assertThrows<IllegalArgumentException>("빈 문자열을 포함할 수 없습니다.") {
            RaceCar(" obar")
        }
    }

    @Test
    fun `자동차 이름 길이는 1 ~ 5 범위를 벗어날 수 없다`() {
        assertThrows<IllegalArgumentException>("자동차 이름은 1 ~ 5 길이 법위를 벗어날 수 없습니다.") {
            RaceCar("foobar")
        }
    }

    @Test
    fun `자동차의 시작 위치는 기본적으로 0 이다`() {
        val startPosition = RaceCar("foo").position
        assertThat(startPosition).isZero()
    }

    @Test
    fun `자동차는 시작 위치를 다른 정수로 바꿀 수 있다`() {
        val plusPosition = RaceCar("foo", startPoint = 1).position
        val minusPosition = RaceCar("foo", startPoint = -1).position
        // then
        assertAll(
            { assertThat(plusPosition).isEqualTo(1) },
            { assertThat(minusPosition).isEqualTo(-1) },
        )
    }

    @Test
    fun `자동차의 위치가 0 에 있을 때, score가 5 ~ 9 사이라면 자동차의 다음 위치는 1 이다`() {
        // given
        val raceCar = RaceCar("foo")
        val expectedPosition = 1
        // when
        raceCar.move(5)
        val actualPosition = raceCar.position
        // then
        assertThat(actualPosition).isEqualTo(expectedPosition)
    }

    @Test
    fun `자동차의 위치가 0 에 있을 때, score가 5 보다 작으면 자동차의 다음 위치는 0 이다`() {
        // given
        val raceCar = RaceCar("foo")
        val expectedPosition = 0
        // when
        raceCar.move(4)
        val actualPosition = raceCar.position
        // then
        assertThat(actualPosition).isEqualTo(expectedPosition)
    }

    @Test
    fun `자동차 움직이는 전략을 바꿔, 자동차를 무조건 뒤로만 움직이게 할 수 있다`() {
        // given
        val startPoint = 0
        val raceCar = RaceCar("foo", startPoint) { -1 }
        val expectedPosition = -1
        // when
        raceCar.move(score = 3)
        val actualPosition = raceCar.position
        // then
        assertThat(actualPosition).isEqualTo(expectedPosition)
    }

    @Test
    fun `자동차의 position을 비교할 수 있다`() {
        // given
        val raceCar1 = RaceCar("foo", 2)
        val raceCar2 = RaceCar("bar", 3)
        // then
        assertThat(raceCar1.comparePosition(raceCar2)).isEqualTo(-1)
    }
}
