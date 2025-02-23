package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.global.Configure.RANDOM_SEED
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
}
