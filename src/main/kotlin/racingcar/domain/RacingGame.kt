package racingcar.domain

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import kotlin.streams.toList

class RacingGame (cars:List<Name>, laps:Laps){
    private val cars : Cars
    private var laps : Laps

    init{
        this.cars = initCars(cars)
        this.laps = laps
    }

    fun isEnd() : Boolean{
        return laps.isEnd()
    }

    fun race(){
        cars.moveCars()
        laps = laps.next()
    }

    fun winner() : Cars{
        return cars.findWinners()
    }

    private fun initCars(carNames: List<Name>): Cars {
        val carList = carNames.stream()
            .map { Car(it) }
            .toList()
        return Cars(carList)
    }

    fun result(): Cars {
        return cars
    }
}