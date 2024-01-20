package controller

import domain.Car
import domain.GamingCars

class GameController {

    lateinit var gamingCars: GamingCars
    fun gaming() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val names = readln()
        createCarName(names)

        println("시도할 회수는 몇회인가요?")
        val tryNumber: Int = readln().toInt()
        println()
        println("실행결과")
        tryCount(tryNumber)

        winGame()
    }

    fun createCarName(names: String) {
        val carNames: List<String> = names.split(",")
        val Cars: List<Car> = carNames.map { name -> Car(name) }
        gamingCars = GamingCars(Cars)
    }

    fun tryCount(tryNumber: Int) {
        for (i in 1..tryNumber) {
            gamingCars.movingForward()
            gamingCars.cars.forEach {
                println(it.name + " : " + calcDistanceView(it.distance))
            }
            println()
        }
    }

    private fun calcDistanceView(distance: Int): String {
        val distanceView = StringBuilder()
        for (i in 0..distance) {
            distanceView.append("-")
        }
        return distanceView.toString()
    }

    fun winGame() {
        val winnerCarsName = gamingCars.calcWinnerCars()
            .map(Car::name)
            .toList()
            .joinToString(", ")
        println(winnerCarsName + "가 최종 우승했습니다.")
    }
}