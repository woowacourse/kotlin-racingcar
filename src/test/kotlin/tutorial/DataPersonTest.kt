package tutorial

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class DataPersonTest {

    @DisplayName("데이터 클래스 테스트")
    @Test
    internal fun `data classes`() {
        //given
        val person1 = DataPerson("김경록", 20, "로키")
        val person2 = DataPerson("김경록", 20, "로키")

        //when

        //then
        assertThat(person1).isEqualTo(person2)
    }

    @DisplayName("데이터 클래스가 아닌 경우 테스트")
    @Test
    internal fun `not data classes`() {
        //given
        val person1 = Person("김경록", 20, "로키")
        val person2 = Person("김경록", 20, "로키")

        //when

        //then
        assertThat(person1).isNotEqualTo(person2)
    }
}
