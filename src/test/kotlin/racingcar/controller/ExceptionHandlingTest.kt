package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ExceptionHandlingTest {
    lateinit var exceptionHandling: ExceptionHandling
    @BeforeEach
    fun setup(){
        exceptionHandling = ExceptionHandling()
    }
    @Test
    fun `자동차 개수가 1 ~ 20 개 일 때 true를 반환하는지`() {
        val result = exceptionHandling.limitNumberOfCars(10)
        assertThat(result).isTrue()
    }
}