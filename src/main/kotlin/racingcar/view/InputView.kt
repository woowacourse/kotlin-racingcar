package racingcar.view

private const val DELIM = ","

fun readNames(): List<String> {
    return readln().split(DELIM).map { it.trim() }
}
