package racingcar

import java.util.Random

class Util {
    companion object {
        fun tryAndRerun(fn: () -> Unit) {
            while (true) {
                try {
                    fn()
                } catch (e: IllegalArgumentException) {
                    println("[ERROR]: " + e.message)
                    continue
                } catch (e: IllegalStateException) {
                    println("[ERROR]: " + e.message)
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
