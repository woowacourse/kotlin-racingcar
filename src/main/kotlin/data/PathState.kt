package data

private const val DASH = "-"
private const val EMPTY = ""

enum class PathState(val state: String) {
    MOVE(DASH),
    STOP(EMPTY);

    companion object {
        fun List<PathState>.getPathMarks(): String {
            var pathMarks = EMPTY

            this.forEach { pathState ->
                pathMarks += pathState.state
            }

            return pathMarks
        }
    }
}
