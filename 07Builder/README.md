# 복잡한 인스턴스 조립하기.

Builing은 구조를 가진 커다란 건출물입니다. 구조를 가지고 있는 커다란 것을 건축하거나 구축하는 것을 build 라고 합니다.
빌딩을 세울 때 우선 지반을 다지고, 골격을 세우고, 아래에서 위로 조금씩 만들어 갑니다. 일반적으로 복잡한 구조물을 세울 때 한 번에 완성시키기는 어렵습니다.
우선 전체를 구성하고 있는 각 부분을 만들고 단계를 밟아 만들어 나갑니다.

## Builder 패턴

예제로 Builder 패턴을 사용한 '문서'을 작성하는 프로그램

다음과 같은 구조를 가짐

- 타이틀을 한 개 포함
- 문자열을 몃 개 포함
- 개발 항목을 몃 개 포함

Builder 클래스에서는 문서를 구성하기 위한 메소드를 경정.
그리고 Director 클래스가 그 메소드를 사용해서 구체적인 하나의 문서를 만듭니다. Builder클래스는 추상 클래스로서
실제의 처리는 기술되어 있지 않고, 추상 메소드만 선언되어 있습니다.
문서 작성을 위한 구체적인 처리를 결정하는 것은 Builder 클래스의 하위 클래스입니다. 이 예제 프로그램에서는 Bulder 클래스의 하위클래스로 다음과 같은 클래스를 정의합니다

- TextBuilder :플랜테스트를 사용해서 문서 작성
- HTMLBuilder : HTML을 사용해서 문서 작성


Builder 패턴의 등장인물

- Builder(건축자)의 역할

Builder 역할은 인스턴스를 생성하기 위한 인터페이스를 결정합니다.
Builder 역할에는 인스턴스의 각부분을 만들기 위한 메소드가 준비되어 있습니다. 예제 프로그램에서는 Builder

- ConcreateBuilder(구체적인 건축자)의 역할
ConcreateBuilder 역할은 Builder 역할의 인터페이스(API)를 구현하고 있는 클래스입니다.
실제의 인스턴스 작성으로 호출되는 메소드가 여기에서 정의됩니다. 또한 최종적인 결과를 얻기 위한 메소드가 준비.
예제 프로그램에서는 TextBuilder 와 HTMLBuilder가 이에 해당합니다.

- Director(감독자)의 역할
Director역할은 Builder 역할의 인터페이스(API)를 사용해서 인스턴스를 생성합니다.
ConcreateBuilder 역할에 의존한 프로그래밍은 수행하지 않습니다.
ConcreateBulder 역할과 관계없이 제대로 기능하도록 Builder 역할의 메소드만을 사용합니다.
예제 프로그램에서는 Director클래스가 이 역할.

- Client(의뢰인)의 역할
 Builder 패턴을 이용하는 역할입니다 이건 Main 클래스.


 ## 독자의 사고를 넓히기 위한 힌트

 1. 누가 무엇을 알고 있을까?
 오브젝트 지향 프로그램에서 '누가 무엇을 알고 있을까?'라는 화두는 상당히 중요합니다.
 즉 클래스가 어떤 메소드를 사용할 수 있을까?에 주의해서 프로그래밍.

 Main 클래스는 Builder 클래스의 메소드를 모릅니다.(호출 X)
 Main 클래스는 Director 클래스의 construct 메소드만을 호출.
 그러면 Director 클래스 안에서 조용히 일이 진행되고 문서가 완성

 Director 클래스가 자신이 이용하고 있는 Builder 클래스의 하위 클래스를 모르는 것은 정말 잘된 일입니다.
 왜냐하면 모르기 때문에 교체할 수 있기 때문입니다. TextBuilder의 인스턴스를 Director에 제공하거나
 Director의 HTMLBuilder의 인스턴스를 Director에 제공해도 제대로 기능하는 것은 Director 클래스가 Builder 클래스의 구체적인 하위 클래스를 '모르기' 때문입니다.
 모르기 때문에 교환이 가능하고, 교체가 가능하기 때문에 부품으로서 가치가 높습니다.
 ㅇㅣ '교환가능성' 에 대해서 클래스의 설계자는 항상 기억할 필요가 있습니다.

 2. 설계 시에 결정할 수 있는 것과 결정할 수 없는 것

 Builder 클래스는 문서를 구축 할 때 필요 충분한 메소드 군을 선언해야 합니다.
 Director 클래스에 주어진 도구는 Builder 클래스가 제공하는 도구이기 때문에 Builder클래스의 메소드로서 무엇을 준비해야 할지는 중요.
 더구나 Builder 클래스는 앞으로 늘어날지도 모르는 Builder 클래스의 하위 클래스의 요구에도 대응할 필요가 있습니다.
 예제 프로그램에서는 일반 텍스트와 HTMl파일만 만듬.
 그러나 미래에 다른 형식으로 만들ㄸㅐ는 어떻게 대응해야 될까요?

 미래를 예측할 수 없지만 단지 가까운 미래를 대비할 수 이ㅣㅆ음.


 StringBuffer를 쓰는 이유는??
 메모리 소비를 줄이기 위해서. 새로운 인스턴스 생성을 막기 위해서.