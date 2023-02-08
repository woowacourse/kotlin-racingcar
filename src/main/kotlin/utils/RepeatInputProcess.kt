package utils

object RepeatInputProcess {
    fun repeat(inputProcess: () -> Any): Any {
        while (true) {
            return handleError(inputProcess)
        }
    }

    private fun handleError(inputProcess: () -> Any): Any {
        return try {
            inputProcess()
        } catch (e: IllegalArgumentException) {
            println(e.message.toString())
        }
    }
}
