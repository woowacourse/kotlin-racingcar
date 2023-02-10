package dto

import data.ComparisonResult

class RaceResultDTO(
    private val comparisonResult: ComparisonResult,
    private val distance: Int,
    private val name: String
) {
    fun getComparisonResult() = comparisonResult

    fun getDistance() = distance

    fun getName() = name
}
