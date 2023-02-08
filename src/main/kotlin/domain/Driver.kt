package domain

import util.DriverDecision

class Driver {

    fun decideGoAndStop(randomNum: Int): DriverDecision {
        if (randomNum > BOUNDARY) {
            return DriverDecision.GO
        }
        return DriverDecision.STOP
    }

    companion object {
        private const val BOUNDARY = 3
    }
}
