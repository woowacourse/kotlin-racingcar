# 자동차 경주 게임
## Car
### field
- name: String
- position: Int
### method
- getInfo: Pair<String, Int>
- move

## Cars
### field
- cars: List<Car>
### method
- mappingCars
- getCar
- getCarSize
- move
- findMaxPosition
- findWinners

## InputView
- inputCarNames: List<Car>
- inputTryNumber: String?

## OutputView
- outputCarNames
- outputTryNumber
- outputResult
- outputResults
- outputWinners
- outputErrorMessage

## RandomGenerator
- getRandomNumber: Int

## RaceGame
- tryMove
- equalMaxValue
- run
- executeInputTryNumber
- getInputTryNumber
- executeInputCarNames
- getInputCarNames

## Constants

## Validator
- checkNames
- checkName
- checkNameSize
- checkNameNull
- checkNameEmpty
- checkTryNumber
- checkTryNumberNull
- checkTryNumberIsRight
- checkNameRight
