package basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("신지혜", 20, "아마찌"),
            Person("신지혜", 20, nickname = "아마찌"),
            Person(name = "신지혜", nickname = "아마찌", age = 20)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("신지혜")
            assertThat(it.age).isEqualTo(20)
            assertThat(it.nickname).isEqualTo("아마찌")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("신지혜", null, null)
        assertThat(person.name).isEqualTo("신지혜");
        assertThat(person.age).isNull();
        assertThat(person.nickname).isNull();
    }

    @Test
    fun `default arguments`() {
        val person = Person("아마찌")
        assertAll(
            { assertThat(person.name).isEqualTo("아마찌") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("신지혜", 29, "아마찌")
        val person2 = Person("신지혜", 29, "아마찌")
        assertThat(person1).isEqualTo(person2)
    }
}

