package racingcar.racingcar.domain.raceresult

data class RaceResultDto(
    val result: List<StepResultDto>,
)

data class StepResultDto(
    val racers: List<RacerResultDto>,
)

data class RacerResultDto(
    val name: String,
    val location: Int,
)
