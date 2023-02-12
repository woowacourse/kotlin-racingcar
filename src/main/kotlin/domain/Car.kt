package domain

import dto.CarMetadataDTO
import kotlin.math.max

class Car(
    private val generator: NumberGenerator,
    private val name: String,
    private var distance: Int = 0
) {

    fun race(): CarMetadataDTO {
        val number = generator.generate()
        if (checkGo(number)) go()
        return CarMetadataDTO(distance, name)
    }

    fun compareDistance(winnerDistance: Int): Int {
        return max(winnerDistance, distance)
    }

    fun isWinner(winnerDistance: Int): String {
        if (winnerDistance == distance) {
            return name
        }
        return ""
    }

    private fun checkGo(number: Int): Boolean {
        return number in RANGE_LOWER_INCLUSIVE..RANGE_UPPER_INCLUSIVE
    }

    private fun go() {
        distance++
    }

    companion object {
        const val RANGE_LOWER_INCLUSIVE = 4
        const val RANGE_UPPER_INCLUSIVE = 9
    }
}
