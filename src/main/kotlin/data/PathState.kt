package data

private const val MOVE_MARK = "-"
private const val STOP_MARK = ""

enum class PathState(val state: String) {
    MOVE(MOVE_MARK),
    STOP(STOP_MARK);

    companion object {
        fun List<PathState>.getPathMarks(): String {
            var pathMarks = ""

            this.forEach { pathState ->
                pathMarks += pathState.state
            }

            return pathMarks
        }
    }
}
