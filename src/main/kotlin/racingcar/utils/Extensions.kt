package racingcar.utils

fun List<String>.removeBlank(): List<String> =
    this.map { it.trim() }
