package tutorial

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Person Test")
internal class PersonTest {

    @DisplayName("이름 붙인 인자 테스트")
    @Test
    internal fun `name arguments`() {
        //given
        val persons = listOf(
            Person("김경록", 20, "roki"),
            Person("김경록", 20, nickname = "roki"),
            Person(name = "김경록", age = 20, nickname = "roki")
        )

        //when
        val addedPersons = persons.plus(Person("이지은", age = 29, nickname = "IU"))

        //then
        assertThat(persons).hasSize(3)
        assertThat(addedPersons).hasSize(4)
    }

    @DisplayName("널 타입 테스트")
    @Test
    internal fun `nullable types`() {
        //given
        val person = Person("김경록", null, null)

        //when

        //then
        assertThat(person.name).isEqualTo("김경록")
        assertThat(person.age).isNull()
        assertThat(person.nickname).isNull()
    }
}
