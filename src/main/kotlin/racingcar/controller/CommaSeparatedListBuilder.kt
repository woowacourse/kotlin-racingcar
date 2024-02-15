package racingcar.controller

import racingcar.model.Settings

class CommaSeparatedListBuilder() {
    fun commaSeparatedListBuild(carNamesText: String) = carNamesText.split(Settings.CAR_NAME_DELIMITERS).map { it.trim() }
}
