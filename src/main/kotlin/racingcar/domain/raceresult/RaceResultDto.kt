package racingcar.racingcar.domain.raceresult

data class RaceResultDto(
    val names: List<String>,
    val result: List<StepResultDto>,
)

data class StepResultDto(
    val locations: List<Int>,
)
