package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.global.Configure.RANDOM_SEED
import kotlin.random.Random

class RaceServiceTest {
    private val random = Random(RANDOM_SEED)
    private val raceService = RaceService(random)

    @Test
    @DisplayName("모든 경주가 종료된 후, 가장 멀리 이동한 자동차가 최종 우승자이다")
    fun t1() {
        val a = Car("a")
        repeat(3) { a.moveForward(6) }

        val b = Car("b")
        repeat(1) { b.moveForward(6) }

        val cars = listOf(a, b)
        assertThat(raceService.getWinner(cars)).contains(a)
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 모두 우승자로 처리한다")
    fun t2() {
        val a = Car("a")
        repeat(3) { a.moveForward(6) }

        val b = Car("b")
        repeat(3) { b.moveForward(6) }

        val cars = listOf(a, b)
        assertThat(raceService.getWinner(cars))
            .contains(a)
            .contains(b)
    }

    // public 메서드만 현재 테스트한다. 내부적으로 여러 private 메서드를 호출하는데, 굳이 private 메서드를 테스트 할 필요가 있을까?
    @Test
    @DisplayName("각 자동차의 이름과 현재까지의 이동 거리를 출력합니다.")
    fun t3() {
        val a = Car("a")
        val b = Car("b")
        val c = Car("c")

        assertThat(
            raceService
                .race(
                    listOf(
                        listOf(6, 6, 3),
                        listOf(6, 3, 6),
                    ),
                    listOf(a, b, c),
                ).toString(),
        ).contains(
            """
            a : -
            b : -
            c : 

            a : --
            b : -
            c : -
            """.trimIndent(),
        )
    }
}
