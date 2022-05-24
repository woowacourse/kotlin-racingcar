package racingcar.view

fun readNames(): List<String> {
    return readln().split(",").map { it.trim() }
}