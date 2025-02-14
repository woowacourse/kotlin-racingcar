package racingcar.extension

operator fun String.times(times: Int): String = List(times) { this }.joinToString(separator = "")
