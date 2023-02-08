package service

import model.Car

class ConvertToOutputFormat {
    fun convertRoundResult(carsInfo: List<Car>): String {
        var result = ""
        carsInfo.forEach { car ->
            result += "${car.name} : ${addHyphen(car.position)}\n"
        }
        return result
    }

    fun addHyphen(position: Int): String {
        var result = ""
        for (i in 1..position) result += "-"
        return result
    }

    fun convertWinnerResult(winners: List<String>): String {
        var result = "최종 우승자: "
        result += winners.joinToString(", ")
        return result
    }
}
