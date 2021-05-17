package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {
    @Test
    internal fun `named arguments`() {
        val people = listOf(
            Person("장세환", 28, "아론"),
            Person("장세환", 28, nickname = "아론"),
            Person(name = "장세환", age = 28, nickname =  "아론")
        )
        assertThat(people).allSatisfy() {
            assertThat(it.name).isEqualTo("장세환")
            assertThat(it.age).isEqualTo(28)
            assertThat(it.nickname).isEqualTo("아론")
        }
    }

    @Test
    internal fun `nullable types`() {
        val person = Person("장세환", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("장세환") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    internal fun `default arguments`() {
        val person = Person("장세환")
        assertAll(
            { assertThat(person.name).isEqualTo("장세환") },
            { assertThat(person.age).isEqualTo(0) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    internal fun `data classes`() {
        val person1 = Person("장세환", 28, "아론")
        val person2 = Person("장세환", 28, "아론")
        val person3 = Person("장세환", 28, "아롱")

        assertThat(person1).isEqualTo(person2)
        assertThat(person1).isNotEqualTo(person3)
    }
}

