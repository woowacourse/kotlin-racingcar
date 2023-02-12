package racingcar.misc

object Util {
    fun tryAndRerun(fn: () -> Unit) {
        while (true) {
            try {
                fn()
            } catch (e: IllegalArgumentException) {
                println("잘못된 입력 : " + e.message)
                continue
            }
            break
        }
    }
}
