import data.CarPath
import data.PathState

fun List<PathState>.getPathMarks(): String {
    var pathMarks = ""

    this.forEach { pathState ->
        pathMarks += pathState.state
    }

    return pathMarks
}

fun CarPath.subPath(number: Int) = this.path.subList(0, number + 1)
