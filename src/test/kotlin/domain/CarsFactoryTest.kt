package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsFactoryTest {

    @Test
    fun `자동차는 2대에서 20대 이하여야 하고 이름에 중복이 없어야 한다`() {
        val names = listOf("pobi", "woni", "jun")
        assertDoesNotThrow { CarsFactory(names) }
    }

    @Test
    fun `자동차 개수는 20대를 넘어갈 수 없다`() {
        val names = List(21) { ('a' + it).toString() }
        val exception = assertThrows<IllegalArgumentException> { CarsFactory(names) }
        assertThat(exception.message).isEqualTo(CarsFactory.ERROR_CAR_COUNT)
    }

    @Test
    fun `자동차 한 대로는 경주할 수 없다`() {
        val names = listOf("pobi")
        val exception = assertThrows<IllegalArgumentException> { CarsFactory(names) }
        assertThat(exception.message).isEqualTo(CarsFactory.ERROR_CAR_COUNT)
    }

    @Test
    fun `자동차는 같은 이름으로 만들 수 없다`() {
        val names = listOf("pobi", "woni", "pobi")
        val exception = assertThrows<IllegalArgumentException> { CarsFactory(names) }
        assertThat(exception.message).isEqualTo(CarsFactory.ERROR_CAR_UNIQUENESS)
    }
}
