package racingcar.racingcar.domain.raceresult

fun RaceResult.toDto(): RaceResultDto {
    return RaceResultDto(
        result = this.result.map { it.toDto() },
    )
}

fun StepResult.toDto(): StepResultDto {
    return StepResultDto(
        racers = this.racers.map { it.toDto() },
    )
}

fun RacerResult.toDto(): RacerResultDto {
    return RacerResultDto(
        name = this.name,
        location = this.location,
    )
}
