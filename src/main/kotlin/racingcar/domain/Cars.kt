package racingcar.domain

class Cars(private val cars: ArrayList<Car>) {

    constructor(carNum: Int) : this(ArrayList()) {
        createList(carNum)
    }

    private fun createList(carNum: Int) {
        for (i in 0 until carNum) {
            cars.add(Car(RandomMoveStrategy()))
        }
    }


    fun cars(): List<Car> {
        return cars.toList()
    }

    fun race() {
        cars.stream()
            .forEach { car -> car.move() }

    }

}