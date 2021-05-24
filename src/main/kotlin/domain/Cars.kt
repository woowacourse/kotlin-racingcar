package domain

import kotlin.random.Random

class Cars(val cars: List<Car>) {
    fun randomMove(random: Random, randomMax: Int, boundary: Int) {
        this.cars.forEach { car ->
            if (random.nextInt(randomMax) > boundary) car.move()
        }
    }
}
