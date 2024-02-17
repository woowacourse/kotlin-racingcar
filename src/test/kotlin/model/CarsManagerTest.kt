package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CarsManagerTest {
    @ParameterizedTest
    @MethodSource("provideRandomNumberExample")
    fun `한 라운드 랜덤 수가 3이하일 시 자동차의 전진 수는 0이고 4이상일 시 1이다`(
        randomNumber: Int,
        forwardCount: Int,
    ) {
        val carsManager = CarsManager(listOf("가나,다라,마바,사")) { randomNumber }
        carsManager.move()
        assertThat(carsManager.cars.all { it.forwardCount == forwardCount }).isTrue
    }

    @Test
    fun `자동차들의 전진 수를 비교 후 더 큰 자동차의 이름을 반환한다`() {
        val carsManager = CarsManager(listOf("가나", "다라")) { 1 }
        carsManager.cars.forEachIndexed { index, car ->
            car.moveForward(isMoveExample[index])
        }
        assertThat(carsManager.getWinners()).isEqualTo(listOf("가나"))
    }

    companion object {
        val isMoveExample = listOf(true, false)

        @JvmStatic
        fun provideRandomNumberExample() =
            listOf(
                Arguments.of(2, 0),
                Arguments.of(3, 0),
                Arguments.of(4, 1),
                Arguments.of(5, 1),
            )
    }
}
