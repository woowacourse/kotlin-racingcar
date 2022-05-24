package racingcar.domain

class Count(val value: Int) {

    init {
        require(value in 1..1000) {"1에서 1000 사이의 숫자를 입력하세요."}
    }
}