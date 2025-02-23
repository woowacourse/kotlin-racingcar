package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.global.Configure.RANDOM_SEED
import java.lang.IllegalArgumentException
import kotlin.random.Random

class MoveTableTest {
    private val random = Random(RANDOM_SEED)

    @Test
    @DisplayName("MoveTable의 열은 car 리스트의 사이즈, 행은 raceCount와 같아야 한다")
    fun t1() {
        val cars = listOf(Car("a"), Car("b"))
        val moveTable = MoveTable.genTable(cars, 5, random)

        assertThat(moveTable.table.size).isEqualTo(5)
        moveTable.table.forEach {
            assertThat(it).hasSize(2)
        }
    }

    @Test
    @DisplayName("MoveTable의 각 값은 0부터 9 사이여야 한다")
    fun t2() {
        val cars = listOf(Car("a"), Car("b"))
        val moveTable = MoveTable.genTable(cars, 5, random)

        moveTable.table.forEach {
            it.forEach { num ->
                assertThat(num in 0..9).isTrue()
            }
        }
    }

    @Test
    @DisplayName("MoveTable에서 임의의 이동 값을 입력받을 수 있다")
    fun t3() {
        val cars = listOf(Car("a"), Car("b"))
        val moveTable =
            MoveTable(
                listOf(
                    listOf(1, 1),
                    listOf(1, 1),
                    listOf(1, 1),
                    listOf(1, 1),
                    listOf(1, 1),
                ),
                cars,
            )

        assertThat(moveTable.table.size).isEqualTo(5)
        moveTable.table.forEach {
            assertThat(it).hasSize(2)
        }
    }

    @Test
    @DisplayName("MoveTable에서 올바르지 않은 값을 입력받았을 때 IllegalArgumentException을 반환한다")
    fun t4() {
        val cars = listOf(Car("a"), Car("b"))
        assertThrows<IllegalArgumentException> {
            MoveTable(
                listOf(
                    listOf(1),
                    listOf(1, 1),
                    listOf(1, 1),
                    listOf(1, 1),
                    listOf(1, 1),
                ),
                cars,
            )
        }
    }

    @Test
    @DisplayName("MoveTable에서 올바르지 않은 값을 입력받았을 때 IllegalArgumentException을 반환한다")
    fun t4_1() {
        val cars = listOf(Car("a"), Car("b"))
        assertThrows<IllegalArgumentException> {
            MoveTable(
                listOf(
                    listOf(1, 10),
                    listOf(1, 1),
                    listOf(1, 1),
                    listOf(1, 1),
                    listOf(1, 1),
                ),
                cars,
            )
        }
    }

    @Test
    @DisplayName("MoveTable에서 올바르지 않은 값을 입력받았을 때 IllegalArgumentException을 반환한다")
    fun t4_2() {
        val cars = listOf(Car("a"), Car("b"), Car("c"))
        assertThrows<IllegalArgumentException> {
            MoveTable(
                listOf(
                    listOf(1, 1),
                    listOf(1, 1),
                    listOf(1, 1),
                    listOf(1, 1),
                    listOf(1, 1),
                ),
                cars,
            )
        }
    }
}
