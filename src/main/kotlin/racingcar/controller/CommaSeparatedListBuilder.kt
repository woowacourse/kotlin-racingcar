package racingcar.controller

class CommaSeparatedListBuilder(
    private val carNamesText: String,
) {

    fun commaSeparatedListBuild() = carNamesText.split(",")
}