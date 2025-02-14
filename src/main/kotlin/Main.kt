import racingcar.Car
import racingcar.Racecourse

fun main() {
    val cars: List<Car> = readCars()
    val round: Int = readRound()
    println("\n실행결과")
    val racecourse = Racecourse(cars, round)
    racecourse.startRace()
}

fun readCars(): List<Car> {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

    runCatching {
        val userInput: String = readlnOrNull() ?: throw IllegalArgumentException(ERROR_MESSAGE_FAIL_TO_READ_INPUT)
        Car.createCars(userInput)
    }.onSuccess { cars: List<Car> ->
        return cars
    }.onFailure { error: Throwable ->
        println(error.message)
        return readCars()
    }

    throw IllegalStateException(ERROR_MESSAGE_RUNCATCHING_NO_RESULT)
}

fun readRound(): Int {
    println("시도할 횟수는 몇 회인가요?")

    runCatching {
        val userInput: String = readlnOrNull() ?: throw IllegalStateException(ERROR_MESSAGE_FAIL_TO_READ_INPUT)
        parseToRound(userInput)
    }.onSuccess { round: Int ->
        return round
    }.onFailure { error: Throwable ->
        println(error.message)
        return readRound()
    }

    throw IllegalStateException(ERROR_MESSAGE_RUNCATCHING_NO_RESULT)
}

fun parseToRound(value: String): Int {
    require(value.toIntOrNull() != null && value.toInt() > 0) {
        ERROR_MESSAGE_INVALID_ROUND
    }

    return value.toInt()
}

const val ERROR_MESSAGE_RUNCATCHING_NO_RESULT = "runCatching didn't success and didn't fail also"
const val ERROR_MESSAGE_FAIL_TO_READ_INPUT: String = "입력에 오류가 발생했습니다. 다시 입력해주세요."
const val ERROR_MESSAGE_INVALID_ROUND: String = "시도할 횟수는 1 이상의 자연수여야 합니다. 다시 입력해주세요."
