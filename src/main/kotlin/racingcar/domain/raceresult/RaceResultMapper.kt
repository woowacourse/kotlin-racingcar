package racingcar.racingcar.domain.raceresult

fun RaceResult.toDto(): RaceResultDto {
    return RaceResultDto(
        names = this.names,
        result = this.result,
    )
}
