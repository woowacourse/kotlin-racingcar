package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

// constructor, getter, if var setter
// no field, property based
// use private to access private
// 클래스 옆 소괄호는 주 생성자
// 생성자를 감추고 싶을 때 소괄호 앞 private constructor 라고 적어줄 수 있음
// val, var은 property에만 붙는다.
// primary constructor 에 default value를 줄 수 있음
// type ? == nullable
// data class == equalsAndHashcode, copy, toString(), 생성자에 존재하는 프로퍼티를 기준으로 생성
// 코틀린은 기본값이 존재해야 한다.
data class Person(val name: String, val age: Int, val nickname: String? = name) {
    var phoneNumber: String = ""

    fun greeting() {
        println("Hello $name")
    }
}

class PersonTest {

    @Test
    fun name() {
        assertDoesNotThrow {
            val person = Person("최재훈", 26, "후니")
            val personSub = Person("최재훈", 26)
            val personBuilder = Person("최재훈", nickname = "후니", age = 20)
        }
    }

    @Test
    fun nullable() {
        assertDoesNotThrow {
            val person = Person("최재훈", 26, null)
        }
    }

    @Test
    fun `data class`() {
        val person1 = Person("최재훈", 26, "huni")
        val person2 = Person("최재훈", 26, "huni")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun setter() {
        val person = Person("최재훈", 26, "huni")
        assertThat(person.phoneNumber).isEmpty()
        person.phoneNumber = "01012345678"
        assertThat(person.phoneNumber).isEqualTo("01012345678")
    }

    // 주생성자에 존재하는 프로퍼티에 대해서만 equalsAndHashcode를 사용함
    @Test
    fun `equals`() {
        val person1 = Person("최재훈", 26, "huni")
        person1.phoneNumber = "01012345678"
        val person2 = Person("최재훈", 26, "huni")
        person2.phoneNumber = "01087654321"
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun greeting() {
        val person = Person("최재훈", 26, "huni")
        person.greeting()
    }
}

fun main() {
    val person = Person("최재훈", 26, "huni")
    person.greeting()
}
