package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarsTest {
    private lateinit var cars: Cars
    private val names = listOf("pobi", "woni", "jun", "ver", "glo")

    @BeforeEach
    fun setUp() {
        cars = Cars(
            object : NumberGenerator {
                private val numbers = mutableListOf(2, 5, 3, 9, 6, 4, 1, 3, 7, 8)

                override fun generate(): Int {
                    return numbers.removeAt(0)
                }
            },
            names,
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "pobi", "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u"])
    fun `자동차 갯수가 2대 이상 20대 이하가 아니면 에러가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Cars(
                object : NumberGenerator {
                    private val numbers = mutableListOf(2, 5, 3, 9, 6, 4, 1, 3, 7, 8)

                    override fun generate(): Int {
                        return numbers.removeAt(0)
                    }
                },
                input.split(","),
            )
        }
        assertThat(exception.message).contains(Cars.ERROR_CAR_COUNT)
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,woni,pobi"])
    fun `자동차 이름에 중복이 있으면 에러가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Cars(
                object : NumberGenerator {
                    private val numbers = mutableListOf(2, 5, 3, 9, 6, 4, 1, 3, 7, 8)

                    override fun generate(): Int {
                        return numbers.removeAt(0)
                    }
                },
                input.split(","),
            )
        }
        assertThat(exception.message).contains(Cars.ERROR_CAR_UNIQUENESS)
    }

    @Test
    fun `1회 경주`() {
        val expected = listOf(0, 1, 0, 1, 1)
        val results = cars.raceOneTime()
        results.forEachIndexed { index, result ->
            assertThat(result.distance).isEqualTo(expected[index])
        }
    }

    @Test
    fun `우승자 찾기`() {
        for (t in 0 until 2) {
            cars.raceOneTime()
        }
        assertThat(cars.findWinners().names).containsExactly("ver", "glo")
    }
}
