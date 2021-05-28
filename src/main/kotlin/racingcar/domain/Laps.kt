package racingcar.domain

data class Laps(private val laps: Int) {

    init {
        require(laps >= 0) { "시도 횟수는 음수일 수 없습니다." }
    }

    fun next(): Laps {
        return Laps(laps - 1)
    }

    fun isEnd(): Boolean {
        return laps == 0
    }
}

/*
 require(laps >= 0, { "음수일 수 없습니다." }) // Lambda argument should be moved out of parentheses

 require(laps >= 0) { "음수일 수 없습니다." }
 */