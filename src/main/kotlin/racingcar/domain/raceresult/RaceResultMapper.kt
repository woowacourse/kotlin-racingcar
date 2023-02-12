package racingcar.racingcar.domain.raceresult

fun RaceResult.toDto(): RaceResultDto {
    return RaceResultDto(
        names = this.names,
        result = this.result.map { it.toDto() },
    )
}

fun StepResult.toDto(): StepResultDto {
    return StepResultDto(
        locations = this.locations,
    )
}
