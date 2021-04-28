# 자동차 경주 게임

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항

* 주어진 횟수동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 기능 정리
1. 입력받은 횟수만큼 모든 자동차를 전진(혹은 정지) 하도록 하는 기능
    * 입력받은 횟수만큼 각각의 자동차 객체에 notify 를 해 줘야 한다.
2. 자동차 이름을 필드로 갖는 자동차 객체 생성
    * 생성자를 통해 이름을 입력받는다.
    * 이름의 유효성 검증 로직이 있어야 한다.(5글자 이내)
3. 몇 번을 이동할지 입력하는 기능
    * View 영역에서 구현해야 한다.
    * 입력받은 값의 유효성 검증 로직이 있어야 한다.
4. 자동차 이름을 입력받는 기능
    * View 영역에서 구현해야 한다.
    * 자동차 이름은 여러대 입력받을 수 있으며 쉼표(,)를 구분자로 사용한다.
5. 자동차의 전진 조건은 0~9사이의 random 값을 구한 뒤 4이상이면 전진, 3이하면 멈춰야 한다.
    * Random으로 0~9의 숫자를 생성해야 한다.
    * 생성된 숫자를 가지고 전진조건 정지조건 비교해 결과를 반환해야한다.
    * 전진 조건은 바뀔 수 있기 때문에 확장이 가능하게 추상화가 되야한다. - 전략 패턴 사용
6. 경기 종료후 우승자를 찾아야 한다.
    * 경기 결과가 저장된 객체를 구현해야 한다.
    * 경기 결과 객체에서 우승자를 찾는 로직이 필요하다.
    * 우승자는 한 명이상일 수 있다.

## 발생할 수 있는 예외 상황
- 자동차 이름을 5글자 이상 작성하는 경우
- 자동차이름에 공백문자만 입력하는 경우
- 레이싱 진행 횟수 입력시 숫자가 아닌 다른 문자를 입력하는 경우
- 레이싱 진행 횟수 입력시 1회 미만 유효하지 않은 숫자를 입력하는 경우

##  주안점
- 객체지향 프로그래밍 원칙 SOLID를 최대한 지켜가면서 개발을 해야한다.
- 대부분 클린코드 요구사항을 지키면 해결되지만 OCP, DIP의 경우 객체간 의존관계에 유의해야 한다. 
   - 최대한 추상화에 의존하도록 하고 구현체는 설정 영역에서 처리해서 의존관계를 주입하는 형태로 한다.
