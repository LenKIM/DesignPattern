# 상태의 변화를 알려주기

이장에서는 Observer 패턴 에 대해서 배우겠습니다.

observer는 관찰(observe)하는 사람, 즉 관찰자 라는 의미입니다. Observer패턴에서는 관찰 대상의 상태가 변화하면 관찰자에게 알려줍니다. Observer 패턴은 상태 변화에 따른 처리를 기술할 때 효과적입니다.



클래스와 인터페이스 종류

- Observer 관찰자라를 나타내는 인터페이스
- NumberGenerator 수를 생성하는 오브젝트를 나타내는 클래스
- RandomNumberGenerator 랜덤으로 수를 생성하는 클래스
- DigitObserver 숫자로 수를 표시하는 클래스
- GraphObserver 간이 그래프로 수를 표시하는 클래스
- Main 동작 테스트용 클래스

## Observer 인터페이스

'관찰자'를 표현하는 인터페이스이고, 구체적인 관찰자는 이 인터페이스를 구현합니다. 또한, Observer 인터페이스는 예제 프로그램용으로 만을었으며, Java의 클래스 라이브러리에 등장하는 java.util.Observer와는 다릅니다. 차이점은 나중에

update메소드는 수를 생성하는 NumberGenerator 클래스에서 호출됩니다.(Generator는 '생성하는 것' '발생장치' 라는 의미). update메소드는 NumberGenerator 클래스가 '나의 내용이 갱신되었습니다. 표시 쪽도 갱신해 주십시오'라고 Observer에게 전달하기 위한 메소드입니다.



![](https://ws2.sinaimg.cn/large/006tNc79gy1fqokypmew1j31bg0jmjtk.jpg)





## NumberGenerator 클래스

NumberGenerator 클래스는 수를 생성하는 추상 클래스입니다. 실제의 수의 생성(execute 메소드)과 수를 취득하는 부분(getNumber 메소드)은 하위 클래스에서 구현되도록 추상 메소드로 되어 있습니다.(subclass responsiblity).

Observers 필드는 NumberGenerator를 관찰하는 Observer를 보존하는 필드입니다. addObserver는 Observer를 추가하는 메소드이고, deleteObserver는 Observer를 삭제하는 메소드입니다.

NotifyObservers 메소드는 Observer 전원에 대해서 '나의 내용이 갱신되었으므로, 당신의 표시를 갱신해 주십시오'라고 전합니다. 이 메소드 안에서는 observers 안의 Observer들 한 사람 한사람의 update 메소드를 호출하고 있습니다.



## Observer 패턴의 등장인물

Observer 패턴의 등장인물

**Subject(관찰 대상자)의 역할**

Subject는 '관찰되는 대상'을 나타냅니다. Subject 역할은 관찰자인 Observer역할을 등록하는 메소드와 삭제하는 메소드를 가지고 있습니다. 또 '현재의 상태를 취득하는'메소드도 선언되어 있습니다. 예제 프로그램에서는 NumberGenerator 클래스가 이역할을 합니다.

**ConcreateSubject(구체적인 관찰 대상자) 역할**

ConcreateSubject는 구체적으로 '관찰되는 대상'을 표현하는 역할입니다. 상태가 변화되면 그것이 등록되어 있는 Observer역할에 전합니다. 예제 프로그램에서는 RandomNumber Genrerator 클래스가 이 역할을 합니다.

Observer(관찰자)의 역할

Observer는 Subject 역할로부터 '상태가 변했습니다'라고 전달 받은 역할을 합니다. 이를 위한 메소드는 update입니다. 예제 프로그램에서는 Observer 인터페이스가 이 역할을 합니다.

**ConcreateObserver(구체적인 관찰자)의 역할**

ConcreateObserver는 구체적인 Observer입니다. update 메소드가 호출되면 그 메소드안에서 Subject 역할의 현재 상태를 취득합니다. 예제 프로그램에서는 DigitObserver 클래스나 GraphObserver 클래스가 이 역할을 합니다.



## 독자의 사고를 넓히기 위한 힌트

### 여기에도 교환 가능성이 등장?

디자인 패턴의 목적 중의 하나는 클래스를 재이용 가능한 부품으로 만드는 일입니다. Observer 패턴에서는 상태를 가지고 있는 ConcreateSubject 역할과 상태변화를 전달 받은 ConcreateObserver 역할이 등장했습니다. 그리고 이 두가지의 역할을 연갈하는 것이 인터페이인 Subject역할과 Observer 역할입니다.

RandomNumberGenerator 클래스는 현재 자신을 관찰하고 있는 것이(자신이알려주는 상태가)DigitObserver 클래스의 인스턴슨인지 GraphObserver 클래스의 인스턴스인지 몰라도 상관없습니다. 그러나 observer 필드에 저장되어 있는 인스턴스들이 Observer 인터페이스를 구현하고 있다는 것은 알고 있습니다. 이 인스턴스들은 addobserver에서 추가된 것이므로 반드시 Observer 인터페이스를 구현하고 있으며 update 메소드를 호출할 수 있습니다.

한편, DigitObserver 클래스는 자신이 관찰하고 있는 것이 RandomNumberGenerator 클래스의 인스턴스인지, 다른 XXXNumberGenerator 클래스의 인스턴스인지 신경 쓰지 않습니다. 단지 NumberGenerator의 하위 클래스의 인스턴스이고, getNumber 메소드를 가지고 있다는 것은 알고 있습니다.\- 

추상 클래스나 인터페이스를 사용해서 구상 클래스로부터 추상 메소드를 분리한다.

인수로 인스턴스를 전달할 때, 필드에서 인스턴스를 저장할 때에는 구상 클래스의 형태를 사용하지 않고 추상 클래스나 인터페이스의 형태로 해 둔다.

이와 같이 해두면 구상 클래스의 부분을 쉽게 교환할 수 있습니다.

### Observer의 순서

Subject 역할에는 복수의 Observer 역할이 등록되어 있습니다. 예제 프로그램의 notifyObservers메소드에서는 먼저 등록한 Observer의 update 메소드가 먼저 호출됩니다.

일반적으로 Concreateobserver 역할의 클래스를 설계할 경우에는 Update 메소드가 호출되는 순서가 변해도 문제가 일어나지 않도록 해야 합니다. DigitObserver의 update를 호출한 후가 아니라면 GraphObserver의 update가 바르게 동작해야 합니다. 원래 각 클래스의 독립성이 보장되면 의존성의 혼란은 별로 발생하지 않습니다. 그러나 다음과 같은 상황에서는 주의를 해야 합니다.



### Observer의 행위가 Subject에 영향을 미칠 때

이번 예제 프로그램에서는 RandomNumberGenerator가 자신 안에서 데이터를 생성하고 update메소드를 호출했습니다. 그러나 일반적인 Observer 패턴에서는 Subject역할이 다른 클래스로부터 update 메소드의 호출을 요청받는 경우가 있습니다. 그래픽 유저 인터페이스에서는 사용자가 버튼을 눌러 요청하면 update메소드가 호출되는 경우가 자주 있습니다.

그런데 Subject 역할이 update메소드를 호출 할 때 Observer 역할이 호출을 요청하는 경우도 있습니다. 이와같은 경우 조심해서 설계하지 않으면 메소드 호출이 영원히 계속될 가능성이 있습니다. 즉, 이렇게 됩니다.

Subject의 상태가 변화 => Observer에게 전달 => observer가 Subject의 메소드를 호출 =>이것에 의해 Subject의 상태가 변화 => Observer에게 전달



이것을 방지하기 위해서는 Observer 역할에게 '현재 Subject 역할로부터 전달받고 있는 중인지 아닌지'를 나타내는 플래그 변수를 한 개 갖도록 하는 것이 좋습니다.

### 갱신을 위한 힌트 정보의 취득

NumberGenerator는 update 메소드를 사용해서 '갱신되었다'고 Observer에게 통지하고 있습니다. update 메소드의 인수로 주어지고 있는 것은 호출을 행한 nummberGenerator의 인스턴스 뿐이었습니다. Observer는 update메소드 안에서 getNumber를 호출해서 필요한 정보를 얻어야 합니다.

그러나 예제 프로그램에 한정해서 말하면 update메소드의 인수로 갱신된 수 그 자체를 제공해도 상관없습니다. 즉,

> void update(NumberGenerator generator);

가 아니고

> Void update(NumberGenerator generaor, int number);

또는 더욱 단순하게

> void update(int number);

라는 메소드로 합니다.

1) 에서는 Subject 역할만을 전달하고 있습니다. Observer는 Subject 역할로부터 필요에 따라 정보를 얻습니다.

2) 에서는 Subject역할에 대해서 힌트 정보(여기에서는 모든 갱신 정보)를 전달하고 있습니다. 이것으로 Obsever는 Subject역할로부터 정보를 얻는 시간을 줄일 수 있습니다. 단, 이와같이 힌트 정보를 제공한다는 것은 Subject 역할이 Observer 역할의 처리 내용을 의식하고있다는 것입니다.

예제 프로그램보다 복잡한 프로그램의 경우, 정말 Observer 역할에게 필요한 정보는 무엇인지 Subject역할에게 알리는 것은 어려운 문제입니다. 예를 들어 이전 update메소드를 호출하고 나서 현재까지의 사이에 갱신된 정보만을 보낸다고 합시다. 이때 Subject 역할은 시간 계산을 해야 합니다. 따라서, 어느 정도의 힌트 정보를 update메소드에게 제공할지는 프로그램의 복잡성을 고려해서 판단해야 합니다.



### 관찰하기보다 전달 받길 기다린다.

Observer는 관찰자라는 의미이지만 실제로 Observer는 능동적으로 '관찰'하는 것이 아니고, Subject 역할로부터 '전달'되는 것을 수동적으로 기다리고 있습니다. Observer 패턴은 Publish-Subscribe 패턴이라고도 합니다.

