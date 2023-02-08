package racingcar

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
    }
}
