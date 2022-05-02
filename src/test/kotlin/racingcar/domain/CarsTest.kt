package racingcar.domain

import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.stream.Collectors

class CarsTest {

    @Test
    fun duplicateNames() {
        assertThrows<IllegalArgumentException> {
            Cars(listOf("ab", "ab"))
        }.shouldHaveMessage("중복된 이름을 입력하면 안됩니다.")
    }

    @Test
    fun getWinners() {
        val cars = Cars(listOf("a", "b", "c"))

        val fixedMoveStrategy = FixedMoveStrategy(listOf(4, 1, 2, 5, 1, 4))
        cars.race(fixedMoveStrategy)
        cars.race(fixedMoveStrategy)

        val winnerNames = cars.findWinners().stream().map(Car::name).collect(Collectors.toList())
        assertThat(winnerNames).containsExactly("a")
    }
}
