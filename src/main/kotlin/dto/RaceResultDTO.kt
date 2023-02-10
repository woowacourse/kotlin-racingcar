package dto

import data.ComparisonResult

data class RaceResultDTO(
    val comparisonResult: ComparisonResult,
    val distance: Int,
    val name: String
)
