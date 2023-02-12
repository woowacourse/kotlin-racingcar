package dto

import data.ComparisonResult

class CarMetadataDTO(
    private val comparisonResult: ComparisonResult,
    private val distance: Int,
    private val name: String
) {
    fun getComparisonResult(): ComparisonResult {
        return comparisonResult
    }

    fun getDistance(): Int {
        return distance
    }

    fun getName(): String {
        return name
    }
}
