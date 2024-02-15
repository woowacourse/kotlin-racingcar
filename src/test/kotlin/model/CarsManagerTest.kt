package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CarsManagerTest {


    @ParameterizedTest
    @MethodSource("provideRandomNumberExample")
    fun `한 라운드에 따른 자동차 테스트`(randomNumber: Int, forwardCount: Int) {
        val carsManager = CarsManager { randomNumber }
        carsManager.create(listOf("가나,다라,마바,사"))
        carsManager.move()
        assertThat(carsManager.cars.all { it.getForwardCount() == forwardCount }).isTrue

    }

    companion object {

        @JvmStatic
        fun provideRandomNumberExample() = listOf(
            Arguments.of(2, 0), Arguments.of(3, 0), Arguments.of(4, 1), Arguments.of(5, 1)
        )
    }

}