package data

import util.MOVE_MARK
import util.STOP_MARK

enum class PathState(val state: String) {
    MOVE(MOVE_MARK),
    STOP(STOP_MARK)
}
