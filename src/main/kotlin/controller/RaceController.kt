package controller

import constant.InOutConstants
import dto.TryCount
import model.Car
import model.RaceGame
import model.Random
import view.InView
import view.OutView
import kotlin.collections.forEach

class RaceController(val inView: InView, val outView: OutView) {
    fun runProgram() {
        val cars = getCarName()
        val raceGame = RaceGame(getTryCount(), cars)
        val resultList = raceGame.fullRace()
        val winnerList = raceGame.getFinalResult()
        printGameResult(resultList, winnerList)
    }

    fun printRacePosition(raceList: List<List<Car>>) {
        raceList.forEach { race ->
            outView.printCurrentResult(race)
        }
    }

    fun printGameResult(resultList: List<List<Car>>, winnerList: List<Car>) {
        outView.printGameResult()
        printRacePosition(resultList)
        printFinalResult(winnerList)
    }

    fun printFinalResult(winnerResult: List<Car>) {
        outView.printFinalResult(winnerResult)
    }

    fun getCarName(input: String = inView.getData(InOutConstants.NAME)): MutableList<Car> {
        val carNamesList: List<String> = input.split(",").map { it.trim() }.filter { it.isNotBlank() }
        val cars = carNamesList.map { Car(it, randomMaker = Random()) }.toMutableList()
        return cars
    }

    fun getTryCount(): Int {
        val input = inView.getData(InOutConstants.COUNT)
        val count = TryCount(input).tryCountNumber
        return count
    }
}
