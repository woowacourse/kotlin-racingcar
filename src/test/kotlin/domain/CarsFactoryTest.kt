package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsFactoryTest {

    @Test
    fun `자동차 공장에 문제가 없다면 오류가 발생하지 않는다`() {
        val names = listOf("pobi", "woni", "jun")
        assertDoesNotThrow { CarsFactory(names) }
    }

    @Test
    fun `자동차 개수가 20대를 초과하면 에러가 발생한다`() {
        val names = List(21) { ('a' + it).toString() }
        val exception = assertThrows<IllegalArgumentException> { CarsFactory(names) }
        assertThat(exception.message).isEqualTo(CarsFactory.ERROR_CAR_COUNT)
    }

    @Test
    fun `자동차 개수가 1대 미만이면 에러가 발생한다`() {
        val names = listOf("pobi")
        val exception = assertThrows<IllegalArgumentException> { CarsFactory(names) }
        assertThat(exception.message).isEqualTo(CarsFactory.ERROR_CAR_COUNT)
    }

    @Test
    fun `자동차 이름에 중복이 있으면 에러가 발생한다`() {
        val names = listOf("pobi", "woni", "pobi")
        val exception = assertThrows<IllegalArgumentException> { CarsFactory(names) }
        assertThat(exception.message).isEqualTo(CarsFactory.ERROR_CAR_UNIQUENESS)
    }
}
