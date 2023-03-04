package domain

import spock.lang.Specification
import spock.lang.Unroll

class CarTest extends Specification {

    def "car 객체 정상 생성."() {
        when:
        new Car(name)

        then:
        notThrown(Exception)

        where:
        testcase | name
        "1자"     | "a".repeat(1)
        "5자"     | "a".repeat(5)
    }

    @Unroll
    def "car 생성시 #testcase의 경우 에러를 발생시킨다."() {
        when:
        new Car(name)

        then:
        thrown(IllegalArgumentException)

        where:
        testcase    | name
        "이름이 공백"    | ""
        "이름이 6자 이상" | "a".repeat(6)
    }
}
