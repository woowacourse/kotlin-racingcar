package racingcar.misc

import java.util.Random

class Util {
    companion object {
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

        fun generateRandom(): Int {
            return Random().nextInt(10)
        }
    }
}
