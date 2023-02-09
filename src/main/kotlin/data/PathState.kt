package data

import MOVE_MARK
import STOP_MARK

enum class PathState(val state: String) {
    MOVE(MOVE_MARK),
    STOP(STOP_MARK)
}
