package dto

import domain.ComparisonResult

data class RaceResultDTO(
    val comparisonResult: ComparisonResult,
    val distance: Int,
    val name: String
)
