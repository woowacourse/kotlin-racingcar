package view

private const val DELIMITER = ","
private val NUMBER_FORMAT = Regex("^[0~9]+$")

fun inputNames(): List<String> {
    println("게임에 참가할 자동차 이름을 ,로 구분하여 입력해 주세요. 각 자동차의 이름은 1자 이상 5자 이하여야 합니다.")
    return readln().split(DELIMITER)
}

fun inputTotalRound(): Int {
    println("라운드 수를 입력해주세요.")
    val input = readln()
    require(input.matches(NUMBER_FORMAT)) { "라운드 수는 숫자만 입력해야 합니다." }
    return input.toInt()
}
