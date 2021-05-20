package racingcar.domain

class Laps(laps: Int) {

    private val laps: Int

    init {
        if (laps < 0) {
            throw IllegalArgumentException("시도 횟수는 음수일 수 없습니다.")
        }
        this.laps = laps
    }

    fun next(): Laps {
        return Laps(laps - 1)
    }

    fun isEnd(): Boolean {
        return laps == 0
    }
}