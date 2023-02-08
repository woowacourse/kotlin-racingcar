fun List<PathState>.getPathMarks(): String {
    var pathMarks = ""

    this.forEach { pathState ->
        pathMarks += pathState.state
    }

    return pathMarks
}
