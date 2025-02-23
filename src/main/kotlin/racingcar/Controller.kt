package racingcar

import racingcar.domain.Car
import kotlin.random.Random

class Controller(
    private val raceService: RaceService,
    private val view: View,
    private val random: Random,
) {
    fun run() {
        val cars = view.getCars()
        val raceCount = view.getRaceCount()
        val moveTable = genTable(cars, raceCount)

        view.printResult(raceService.race(moveTable, cars))
        view.printWinner(raceService.getWinner(cars))
    }

    // 이동 테이블을 생성, 랜덤값을 이용하기 때문에 테스트 불가능
    // 근데 그러면 genTable이 제대로 생성되는지도 테스트를 해야하는데
    // 즉 결국 테스트 불가능한 부분은 필연적으로 생기는데
    // 이것은 전체 기능 테스트에서만 잡을 수 있는 것인가...?
    private fun genTable(
        cars: List<Car>,
        raceCount: Int,
    ): List<List<Int>> {
        val moveTable = mutableListOf<List<Int>>()
        repeat(raceCount) {
            val singleTable = mutableListOf<Int>()
            repeat(cars.size) {
                singleTable.add(random.nextInt(0, 10))
            }
            moveTable.add(singleTable)
        }

        return moveTable
    }
}
