package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CarsManagerTest {


    @ParameterizedTest
    @MethodSource("provideRandomNumberExample")
    fun `한 라운드에 따른 자동차 테스트`(randomNumber: Int, forwardCount: Int) {
        val carsManager = CarsManager(listOf("가나,다라,마바,사")) { randomNumber }
        carsManager.move()
        assertThat(carsManager.cars.all { it.forwardCount == forwardCount }).isTrue

    }


    @Test
    fun `최종 우승자 반환 테스트`() {
        val carsManager = CarsManager(listOf("가나", "다라")) { 1 }
        carsManager.cars.forEachIndexed { index, car ->
            car.moveForward(isMoveExample[index])
        }
        assertThat(carsManager.getWinners()).isEqualTo(listOf("가나"))
    }

    companion object {
        @JvmStatic
        fun provideRandomNumberExample() = listOf(
            Arguments.of(2, 0), Arguments.of(3, 0), Arguments.of(4, 1), Arguments.of(5, 1)
        )

        val isMoveExample = listOf(true, false)
    }
}
