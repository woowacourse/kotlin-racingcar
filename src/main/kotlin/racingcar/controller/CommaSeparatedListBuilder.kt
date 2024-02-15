package racingcar.controller

class CommaSeparatedListBuilder() {
    fun commaSeparatedListBuild(carNamesText: String,) = carNamesText.split(",").map { it.trim() }
}