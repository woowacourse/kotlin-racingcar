package utils

object RepeatInputProcess {
    fun repeat(inputProcess: () -> Any): Any {
        while (true) {
            try {
                return inputProcess()
            } catch (e: IllegalArgumentException) {
                println(e.message.toString())
            }
        }
    }
}
