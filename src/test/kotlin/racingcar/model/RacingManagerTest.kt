package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.entity.AttemptCount
import racingcar.entity.Car
import racingcar.entity.Name
import racingcar.entity.Position

class RacingManagerTest {
    @Test
    fun `3번의 시도로 레이싱 실행시 각 시도별 기록 저장`() {
        val names = listOf("test1", "test2", "test3")
        val positions = listOf(Position(3), Position(4), Position(2))
        val cars = names.mapIndexed { idx, name -> Car(Name(name), positions[idx]) }
        val sequentialNumberGenerator = SequentialNumberGenerator(listOf(1, 4, 6, 3, 8, 3, 5, 3, 9))
        val carManager = CarManager(sequentialNumberGenerator, cars)
        val racingManager = RacingManager(carManager, AttemptCount(3))

        val attemptHistory = racingManager.run()

        assertThat(attemptHistory.map { it.map { car -> car.position.value } }).isEqualTo(
            listOf(
                listOf(3, 5, 3),
                listOf(3, 6, 3),
                listOf(4, 6, 4)
            )
        )
    }

    @Test
    fun `우승자 결정 시 가장 높은 position을 가진 Car들만 출력`() {
        val names = listOf("test1", "test2", "test3")
        val positions = listOf(Position(4), Position(4), Position(2))
        val cars = names.mapIndexed { idx, name -> Car(Name(name), positions[idx]) }
        val sequentialNumberGenerator = SequentialNumberGenerator(listOf())
        val carManager = CarManager(sequentialNumberGenerator, cars)
        val racingManager = RacingManager(carManager, AttemptCount(3))

        val winner = racingManager.determineWinner()

        assertThat(winner.map { car -> car.name.value }).isEqualTo(listOf("test1", "test2"))
    }
}
