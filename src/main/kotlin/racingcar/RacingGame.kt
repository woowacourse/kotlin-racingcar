package racingcar

class RacingGame {
    fun play() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = readln()
        val names = input.split(",").map { it.trim() }
        val values = mutableListOf<Car>()
        for (name in names) {
            values.add(Car(name))
        }
        val cars = Cars(values)

        println("시도할 회수는 몇회인가요?")
        val count: Int = readln().toInt()
        for (i in 1..count) {
            cars.moveAll()
            for (car in cars.values) {
                println("${car.name} : " + "-".repeat(car.position))
            }
            println()
        }

        val winners = cars.findWinners()
        println("${winners.joinToString { car -> car.name }}가 최종 우승했습니다.")
    }
}