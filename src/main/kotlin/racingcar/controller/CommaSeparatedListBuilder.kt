package racingcar.controller

class CommaSeparatedListBuilder() {
    fun commaSeparatedListBuild(carNamesText: String) =
        carNamesText.split(Regex("\\s*,\\s*")).map { it.trim() }
}
