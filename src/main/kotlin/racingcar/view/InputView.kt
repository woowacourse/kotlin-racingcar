package racingcar.view

fun inputNames(): String {
    println("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분.")
    return readLine() ?: "abs"
}

fun inputLaps(): Int {
    return try {
        println("시도할 횟수는 몇 회인가요?")
        readLine()?.toInt() ?: 0
    } catch (e: Exception) {
        println("[ERROR] 숫자를 입력하셔야 합니다.")
        inputLaps()
    }
}
