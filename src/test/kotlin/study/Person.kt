package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

fun main() {
   val person = Person("kth990303", 23)
   person.greeting()
}

data class Person(val name: String, val age: Int, val nickname: String? = name) {
    var phoneNumber: String = ""

    fun greeting() {
        println("hello$name")
    }
}

class PersonTest {
    @Test
    fun constructor() {
        assertDoesNotThrow {
            Person("kth990303", 23, "K")
        }
        assertDoesNotThrow {
            Person("kth990303", 23)
        }
        assertDoesNotThrow {
            Person(age = 23, name = "kth990303", nickname = "K")
        }
    }

    @Test
    fun nullable() {
        assertDoesNotThrow {
            Person("kth990303", 23, null)
        }
    }

    @Test
    fun `data class`(){
        val person1 = Person("kth990303", 23, "K")
        val person2 = Person("kth990303", 23, "K")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun setter() {
        val person = Person("kth990303", 23, "K")
        assertThat(person.phoneNumber).isEmpty()
        person.phoneNumber="010-1234-5678"
        assertThat(person.phoneNumber).isEqualTo("010-1234-5678")
    }
}