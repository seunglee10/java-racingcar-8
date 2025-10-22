# java-racingcar-precourse

# 자동차 경주 게임
## 프로젝트 개요
주어진 횟수 동안 n대의 자동차가 무작위 값에 따라 전진하거나 멈추는 **자동차 경주 게임**을 구현한다.



##  기능 요구사항

1. 사용자는 경주할 자동차 이름을 입력한다.
    - 이름은 쉼표(`,`)로 구분한다.
    - 각 이름은 5자 이하만 허용한다.
    - 예: `pobi,woni,jun`


2. 사용자는 이동 시도 횟수를 입력한다.
    - 정수만 허용한다.
    - 잘못된 입력 시 `IllegalArgumentException` 발생 후 프로그램 종료.


3. 주어진 횟수 동안 n대의 자동차는 0~9의 난수를 받아 전진 또는 멈춘다.
    - 4 이상이면 전진(`-` 추가)
    - 3 이하이면 멈춤


4. 매 시도 결과를 출력한다.
    - 예:
      ```
      pobi : --
      woni : ---
      jun : ---
      ```


5. 모든 시도 후 최종 우승자(가장 많이 전진한 자동차)를 출력한다.
    - 공동 우승 시 이름을 쉼표(`,`)로 구분하여 출력한다.
    - 예: `최종 우승자 : pobi, jun`

---

##  예시 실행
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)

pobi,woni,jun

시도할 횟수는 몇 회인가요?

5


실행 결과

pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun

---

## 예외 상황
| 구분     | 조건                          | 예외 |
|--------|-----------------------------|------|
| 자동차 이름 | 5자 초과                       | `IllegalArgumentException` |
| 자동차 이름 | 공백 입력                       | `IllegalArgumentException` |
| 자동차 이름 | 같은 이름 중복 입력                 | `IllegalArgumentException` |
| 자동차 이름 | 쉼표(,)로 구분하지 않음, 특수문자를 입력한 경우 | `IllegalArgumentException` |
| 시도 횟수  | 정수가 아님                      | `IllegalArgumentException` |
| 시도 횟수  | 음수 또는 0                     | `IllegalArgumentException` |


---

## 기능 목록 (Feature List)

| 기능 구분 | 기능명 | 설명 |
|------------|--------|------|
| 입력 | 자동차 이름 | Console로 입력받아 List<String>으로 변환 |
| 입력 | 시도 횟수 | Console로 정수 입력 |
| 검증 | 이름 유효성 검사 | 5자 초과, 빈 문자열 검사 |
| 검증 | 시도 횟수 유효성 검사 | 정수형, 양수 검사 |
| 로직 | 자동차 전진 조건 판단 | Randoms.pickNumberInRange(0,9) ≥ 4 |
| 로직 | 라운드별 이동 처리 | 각 자동차별 이동 기록 저장 |
| 출력 | 라운드 결과 | 이름 + '-' 반복 출력 |
| 출력 | 최종 우승자 | 최대 이동 거리 기준 공동 우승 처리 |

---

## 사용 라이브러리
- `camp.nextstep.edu.missionutils.Randoms`
    - `Randoms.pickNumberInRange(0, 9)` : 0~9 사이의 무작위 정수 반환
- `camp.nextstep.edu.missionutils.Console`
    - `Console.readLine()` : 사용자 입력 처리
