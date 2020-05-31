package view.dto

data class PositionsDto(val positions: List<Int>)

data class RoundDto(val round: List<PositionsDto>)