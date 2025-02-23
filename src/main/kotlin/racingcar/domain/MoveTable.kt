package racingcar.domain

import kotlin.random.Random

// cars 를 기반으로 column:cars의 이름, row:raceCount 의 이동 정보를 담은 2차원 리스트 생성
class MoveTable(
    val table: List<List<Int>>,
    val cars: List<Car>,
) {
    init {
        require(table.isNotEmpty()) { "moveTable은 비어있을 수 없습니다." } // 추가된 검증
        table.forEach {
            require(it.size == cars.size) { "moveTable의 내부 리스트 크기가 cars 크기와 일치해야 합니다." }
            it.forEach { num -> require(num in 0..9) { "숫자는 0에서 9 사이여야 합니다" } }
        }
    }

    companion object {
        fun genTable(
            cars: List<Car>,
            raceCount: Int,
            random: Random,
        ): MoveTable {
            val moveTable = mutableListOf<List<Int>>()
            repeat(raceCount) {
                val singleTable = mutableListOf<Int>()
                repeat(cars.size) {
                    singleTable.add(random.nextInt(0, 10))
                }
                moveTable.add(singleTable)
            }

            return MoveTable(moveTable, cars)
        }
    }
}
