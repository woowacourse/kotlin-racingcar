package racingcar.utils.mapper

import racingcar.dto.round.RoundDto
import racingcar.model.round.Round

fun RoundDto.toModel(): Round = Round(count)
