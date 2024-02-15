package racingcar.model

import kotlin.math.max

val START_RANGE = 0
val END_RANGE = 9
val TARGET_NUM = 4

fun move(cars: MutableList<Car>) {
    val randomNum = rand()

    for (car in cars){
        car.position+=goOrStop(randomNum)
    }
}

fun rand() = (START_RANGE..END_RANGE).random()

fun goOrStop(num : Int): String{
    if(num >= TARGET_NUM) return "-"
    return ""
}