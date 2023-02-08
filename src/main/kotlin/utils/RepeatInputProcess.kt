package utils

object RepeatInputProcess {
    fun repeat(inputProcess: () -> Any): Any {
        var result: Any
        do {
            result = handleError(inputProcess)
        } while (result == Unit)
        return result
    }

    private fun handleError(inputProcess: () -> Any): Any {
        return try {
            inputProcess()
        } catch (e: IllegalArgumentException) {
            println(e.message.toString())
        }
    }
}
