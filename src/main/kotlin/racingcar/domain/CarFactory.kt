package racingcar.domain

import java.util.stream.Collectors.toList

object CarFactory {
    fun create(carNames: List<String>): List<Car> = carNames.stream()
        .map { Car(it) }
        .collect(toList())
}