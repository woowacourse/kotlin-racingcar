package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.entity.Car
import racingcar.entity.Name
import racingcar.entity.Position

class CarManagerTest {
    @Test
    fun `CarManager를 생성 할 때 cars의 size가 1이하면 IllegalArgumentException 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            val names = listOf("test1")
            val positions = listOf(Position(3))
            val cars = names.mapIndexed { idx, name -> Car(Name(name), positions[idx]) }
            val sequentialNumberGenerator = SequentialNumberGenerator(listOf())

            CarManager(sequentialNumberGenerator, cars)
        }
    }

    @Test
    fun `모든 자동차에 대해 Position을 기준으로 정렬시 내림차순 정렬 성공`() {
        val names = listOf("test1", "test2", "test3")
        val positions = listOf(Position(3), Position(4), Position(2))
        val cars = names.mapIndexed { idx, name -> Car(Name(name), positions[idx]) }
        val sequentialNumberGenerator = SequentialNumberGenerator(listOf())
        val carManager = CarManager(sequentialNumberGenerator, cars)

        val winners = carManager.sortCarByPosition()

        assertThat(winners[0].name.value).isEqualTo("test2")
    }

    @Test
    fun `모든 자동차에 대해 1회 전진시 성공`() {
        val names = listOf("test1", "test2", "test3")
        val positions = listOf(Position(3), Position(4), Position(2))
        val cars = names.mapIndexed { idx, name -> Car(Name(name), positions[idx]) }
        val sequentialNumberGenerator = SequentialNumberGenerator(listOf(5, 6, 7))
        val carManager = CarManager(sequentialNumberGenerator, cars)

        carManager.attempt()

        assertThat(carManager.cars[0].position.value).isEqualTo(4)
        assertThat(carManager.cars[1].position.value).isEqualTo(5)
        assertThat(carManager.cars[2].position.value).isEqualTo(3)
    }
}
