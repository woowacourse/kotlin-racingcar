package racingcar

import racingcar.model.RandomNumberFactory

class FakeRandomNumberFactory {
    fun unmovableRandomNumberFactory(): RandomNumberFactory {
        return RandomNumberFactory {
            val randomNumberRange = 0..3
            (randomNumberRange).random()
        }
    }

    fun movableRandomNumberFactory(): RandomNumberFactory {
        return RandomNumberFactory {
            val randomNumberRange = 4..9
            (randomNumberRange).random()
        }
    }
}
