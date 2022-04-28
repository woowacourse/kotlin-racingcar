package racingcar

import java.util.stream.Collectors

fun inputNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val input = readLineNotNull()
    return input.split(",").stream()
        .collect(Collectors.toList())
}

fun inputRounds(): Int {
    println("시도할 회수는 몇회인가요?")
    return inputToInt()
}

private fun inputToInt() : Int{
    try {
        return readLineNotNull().toInt()
    } catch (e: NumberFormatException) {
        throw NumberFormatException("[ERROR] 숫자를 입력하세요")
    }
}

private fun readLineNotNull() = readLine() ?: throw NoSuchElementException("[ERROR] 값을 입력하세요")

fun printResultMessage() {
    println("\n실행 결과")
}

fun printCurrentResult(cars: List<Car>) {
    cars.forEach {
        println("${it.name} : ${dash(it.position)}")
    }
    println()
}

private fun dash(position: Int) = "-".repeat(position)

fun printFinalResult(winners: List<String>) {
    println("${winners.joinToString(", ")}가 최종 우승했습니다.")
}

fun printMessage(message: String) {
    println(message)
}


