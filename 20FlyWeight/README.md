# Flyweight 패턴

이 디자인 패턴은 오브젝트(객체)를 '가볍게'하기 위한 것입니다.

오브젝트는 컴퓨터 안에서 가상적으로 존재하는 것이기 때문에 '무겁다' 혹은 '가볍다'락 표현해도 실제의 무게를 나타내는 것은 아닙니다. 여기에서 말하는 무게는 '메모리의 사용량'을 의미합니다. 많은 메모리를 사용하는 오브젝트를 '무겁다'고 표현하고, 적은 메모리를 사용하는 오브젝트를 '가볍다'라고 표현하고 있는 것입니다.



Java에서는

`new Something()`

라는 식으로 Something 클래스의 인스턴스를 만들 수 있습니다. 이때, 그 인스턴스를 저장하기 위해서 메모리가 확보됩니다. Something클래스의 인스턴스가 많이 필요할 때에, new를 많이 하면 메모리의 사용량이 커지게 됩니다.

`인스턴스를 가능한 대로 공유시켜서 쓸데없이 new하지 않도록 한다`

라는 것입니다. 인스턴스가 필요할 때 항상 new하는 것이 아니라, 이미 만들어져 있는 인스턴스를 이용할 수 있으면 그것을 공유해서 사용합니다. 이것이 Flyweight 패턴의 핵심입니다.



## Flyweight 패턴의 등장인물

### Flyweight의 역할

평소대로 취급하면 프로그램이 무거워지기 때문에 공유하는 것이 좋은 것을 나타내는 역할입니다.

### FlywieghtFactory(플라이급의 공장)의 역할

FlywieghtFactory 역할을 만드는 공장의 역할입니다. 이 공장을 사용해서 Flyweight 역할을 만들면 인스턴스가 공유돼ㅣㅂ니다. 예제 프로그램에서는 BigCharFacotry 클래스가 이 역할을 입니다.



## 독자의 사고를 넓히기 위한 힌트

### 여러 장소에 영향을 미친다

Flyweight 패턴에서는 인스턴스를 공유하는 것이 테마,

가장 주의해야 될점은 공유하고 있는 것을 변경하면 **여러 장소에 영향을 미친다.** 는 점

즉, 하나의 인스턴스를 변경하면 그 인스턴스를 사용하고 있는 여러 장소에 동시에 영향을 미칩니다.  여러 장소에 영향을 미치는 것이 항상 나쁜 것은 아니고, 프로그램이 취급하는 문제에 따라서 좋은 점도 있고, 나쁜 점도 있습니다. 어쨌든 공유는 '하나를 변경 하면 극서을 사용하고 있는 장소 전체에 영향을 미친다'라는 특성을 가지고 있습니다.

따라서, Flyweight 역할에서 제공하는 정보는 신중히 선택해야 합니다. 반드시 여러 장소에 공유시켜야할 정보만을 Flyweight역할에게 제공하는 것이 좋습니다.

예를 들어, bigchar에 '색'의 정보를 제공한다고 합시다. BigChar의 인스턴스는 공유되기 때문에 '색'의 정보도 공유됨, 즉, BigString안에서 사용되는 동일한 BigChar의 인스턴스는 반드시 동일한 색을 가지게 됩니다.

또는 bigchar가 아니고 BigString에게 '색'의 정보를 제공한다고 합시다. '3번째의 문자는 빨강'이라는 색 정보를 BigString이 관리하는 것입니다. 이때에는 동일한 BigChar의 인스턴스라도 다른 색으로 할 수 있습니다.

### intrinsic와 extrinsic

앞 절에서 설명한 공유시키는 정보/공유시키지 않는 정보에는 각각 다음과 같은 이름이 붙어 있습니다.

공유시키는 정보는 **intrinsic한 정보** 라고 합니다. 뜻은 원래 구비하고 있다, 본질적인 이라는 의미입니다. 다시 말하면, 인스턴스를 어디에서 가지고 있더라도 어떠한 상황에서도 변하지 않는 정보, 상태에 의존하지 않는 정보입니다. BigChar의 필드 데이터는 BigString의 어디에 등장해도 변하지 않습니다.

한편, 공유시키지 않는 정보를 **extrinsic한 정보** 라고 합니다. 뜻은 '외부에서 온' '비본질적인'이란 의미입니다. 인스턴스를 두는 장소에 따라서 변화하는 정보, 상황에 따라서 변화하는 정보, 상태에 의존하는 정보라는 의미입니다. 두스 장소에 따라서 변화는 정보를 공유시킬 수는 없습니다. 에를 들어, BigChar의 인스턴스가 BigString의 몃 번째 문자인가 하는 정보는 BigChar가 놓이는 장소에 따라 변하기 때문에 BigChar에게 제공할 수는 없습니다.



### 인스턴스와 garbage collection(쓰레기 수집)

BigCharFactory에서 java.util.HashMap을 사용해서 생성한 BigChar의 인스턴스를 관리하고 있습니다. 이와같이 '인스턴스를 관리'하는 기능을 Java에서 실현할 때에는 반드시 '관리되고 있는 인스턴스는 garbage collection되지 않는다'라는 것을 주의



### 메모리 이외의 리소스

예제 프로그램에서 인스턴스를 공유하면 메모리 사용량을 줄일 수 있다고 했습니다. 보다 일반적으로 말하면 인스턴스를 공유하면 인스턴스를 생성하기 위해 필요한 **리소스** 의 양을 줄일 수가 있습니다. 리소스란 컴퓨터 상의 자원이고, 메모리는 리소스의 일종.

시간도 리소스의 일종. 인스턴스를 new할 때에 일정 시간이 걸린다고 합니다.

Flyweight패턴을 사용해서 인스턴스를 공유하면 인스턴스를 new하는 수를 줄일 수 있습니다. 따라서 프로그램의 속도를 높일 수 있습니다.