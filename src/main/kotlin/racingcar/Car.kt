package racingcar

import kotlin.random.Random

class Car(private val name:String, private var distance:Int) {
	private val seed:Int = 134143524
	private val random:Random = Random(seed)

	fun randomMove() {
		if (random.nextInt(0, 10) >= 4 ) distance++
	}

	fun printDistanceInfo() = println("$name : ${ "-".repeat(distance) }")
}