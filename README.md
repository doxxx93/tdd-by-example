# tdd-by-example

## 리듬

1. 재빨리 테스트를 하나 추가한다.
2. 모든 테스트를 실행하고 새로 추가한 것이 실패하는지 확인한다.
3. 코드를 조금 바꾼다.
4. 모든 테스트를 실행하고 전부 성공하는지 확인한다.
5. 리팩토링을 통해 중복을 제거한다.


## 체크리스트

- [ ] $5 + 10CHF = $10(환율이 2:1일 경우)
- [ ] $5 + $5 = $10
- [ ] $5 + $5에서 Money 반환하기
- [x] Bank.reduce(Money)
- [ ] Money에 대한 통화 변환을 수행하는 Reduce
- [ ] Reduce(Bank, String)
- [x] $5 * 2 = $10
- [x] amount를 private으로 만들기
- [x] Dollar 부작용?
- [ ] Money 반올림?
- [x] equals()
- [ ] hashCode()
- [ ] Equal null
- [ ] Equal object
- [x] 5CHF * 2 = 10CHF
- [x] Dollar/Franc 중복
- [x] 공용 equals
- [x] 공용 times
- [x] Franc과 Dollar 비교하기
- [x] 통화?
- [ ] testFrancMultiplication을 지워야 할까?
