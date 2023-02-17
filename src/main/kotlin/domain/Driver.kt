package domain

import domain.numbergenerator.NumberGenerator

class Driver(private val numberGenerator: NumberGenerator) {

    fun decideMovement(): DriverDecision {
        if (numberGenerator.generate() > BOUNDARY) {
            return DriverDecision.GO
        }
        return DriverDecision.STOP
    }

    companion object {
        private const val BOUNDARY = 3
    }
}
