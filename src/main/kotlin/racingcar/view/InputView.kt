package racingcar.view

import racingcar.domain.Laps
import racingcar.domain.Name

object InputView {

    fun inputCarNames(): List<Name> {
        return try {
            println("자동차 이름을 입력하세요.")
            return readLine()!!.split(",").map { Name(it.trim()) }
        } catch (e: Exception) {
            inputCarNames()
        }
    }

    fun inputLaps(): Laps {
        return try {
            println("시도 횟수를 입력하세요.")
            Laps(readLine()!!.toInt())
        } catch (e: Exception) {
            inputLaps()
        }
    }
}


/*
fun inputLaps(): Laps {
    try{
        println("시도 횟수를 입력하세요.")
        return Laps(readLine()!!.toInt())
    }catch (e : Exception){
        return inputLaps()
    }
}

// out of try & tailrec

tailrec fun inputLaps(): Laps {
    return try{
        println("시도 횟수를 입력하세요.")
        Laps(readLine()!!.toInt())
    }catch (e : Exception){
        inputLaps()
    }
}
*/