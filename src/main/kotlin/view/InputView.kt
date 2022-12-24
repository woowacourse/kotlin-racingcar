package view

private const val DELIMITER = ","

fun inputNames(): List<String> {
    println("게임에 참가할 자동차 이름을 ,로 구분하여 입력해 주세요. 각 자동차의 이름은 1자 이상 5자 이하여야 합니다.")
    return readln().split(DELIMITER)
}

fun inputTotalRound(): String {
    println("라운드 수를 입력해주세요.")
    return readln()
}
