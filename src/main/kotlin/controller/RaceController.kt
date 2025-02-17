package controller

import constant.InOutConstants
import dto.CarNames
import dto.TryCount
import model.Car
import model.RaceGame
import model.Random
import view.InView
import view.OutView
import kotlin.collections.forEach

class RaceController(val inView: InView,val outView: OutView) {
    fun runProgram() {
        val cars = getCarName()
        val raceGame = RaceGame(getTryCount(), cars)
        printGameResult()
        val resultList = raceGame.fullRace()
        val winnerList = raceGame.getFinalResult()
        printRacePosition(resultList)
        printFinalResult(winnerList)
    }
    fun printRacePosition(raceList: List<List<Car>>) {
        raceList.forEach{ race ->
            outView.printCurrentResult(race)
        }
    }

    fun printGameResult() {
        outView.printGameResult()
    }

    fun printFinalResult(winnerResult: MutableList<Car>) {
        outView.printFinalResult(winnerResult)
    }
    fun getCarName(): MutableList<Car> {
        val carNames = CarNames(inView.getData(InOutConstants.NAME))
        val cars = carNames.carNamesList.map { Car(it, randomMaker = Random()) }.toMutableList()
        return cars
    }

    fun getTryCount(): Int {
        val input = inView.getData(InOutConstants.COUNT)
        val count = TryCount(input).tryCountNumber
        return count
    }
}
