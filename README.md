# String Calculator

구분자로 이루어진 문자열을 변환, 계산하는 모듈을 만들며 단위 테스트 연습

- 구분자는 콜론(;)과 쉼표(,)
- 다음과 같은 결과가 나와야 한다

```
    - ""          ->  0
    - null        ->  0
    - "1,2"       ->  3
    - "1,2;3"     ->  6
    - "1, 2;3"    ->  6
    - "1,,2;;3"   ->  NumberFormatException
    - "1,a;3"     ->  NumberFormatException
```
