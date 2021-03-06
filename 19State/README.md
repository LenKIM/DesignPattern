# State - 상태를 클래스로 표현하기

오브젝트 지향 프로그래밍에서는 프로그램 할 대상을 '클래스'로 표현합니다. 어떤 것을  클래스로 표현할지는 설계를 하는 사람이 생각해야 합니다. 클래스에 대응하는 구체적인 '사물이 현실에서 존재하는 경우도 있고 존재하지 않는 경우도 있습니다. 경우에 따라서는 '이런 것이 클래스가 될 수 있나?하고 놀랄 정도의 것을 클래스로 하는 경우도 있습니다.



이 장에서 배울 `State 패턴`

에서는 '상태'를 클래스로 표현합니다. State는 '상태(사물의 모양이나 형편)'를 의미합니다. 현실세계에서 우리는 다양한 사물의 '상태'에 대해서 생각합니다. 그러나 상태를 '사물'로 생각할 일이 별로 없기 때문에, 상태를 클래스로 표현한다는 것도 쉽게 이해가 안될 수도 있습니다.

이장에서는 '상태'를 클래스로 표현하는 방법에 대해서 배웁니다. 상태를 클래스로 표현하면 클래스를 교체해서 '상태의 변화'를 표현할 수 있고, 새로운 상태를 추가해야 될 때 무엇을 프로그램하면 좋을지 분명해 집니다.



# 금고경비 시스템

여기에서는 시간마다 경비 상태가 변화하는 금고경비 시스템을 살펴보겠습니다. 금고경비 시스템이라 해도 단순합니다. 이 시스템의 구성도는 다음과 같습니다

금고 경비 시스템

----

- 금고가 1개 있다.
- 금고는 경비센터와 접속되어 있다.
- 금고에는 비상벨과 일반통화용 전화가 접속되어 있다.
- 금고에는 시계가 설치되어 있어 현재의 시간을 감시하고 있다.
  ​
- 주간은 9:00 ~ 16:59, 야간은 17:00 ~ 23:59 및 0:00 ~ 8:59
- 금고는 주간에만 사용할 수 있다.
- 주간에 금고를 사용하면 경비센터에 사용기록이 남는다.
- 야간에 금고를 사용하면 경비센터에 비상사태로 통보가 된다.
- 비상벨은 언제나 사용할 수 있다.
- 비상벨을 사용하면 경비센터에 비상벨 통보가 된다.
- 일반통화용의 전화는 언제나 사용할 수 있다.(그러나 야간은 녹음만 가능)
- 주간에 전화를 사용하면 경비센터가 호출된다.
- 야간에 전화를 사용하면 경비센터의 자동응답기가 호출된다.

---



## State 패턴을 사용하지 않은 유사 코딩

State 패턴을 사용한 예제 프로그램을 설명하기 전에 독자 여러분은 어떤 방식으로 프로그래밍할지 먼저 생각해 보기 바랍니다.

필자라면 앞서의 설명을 읽고 '현재의 시간에 따라서 시스템의 동작이 변한다. 금고사용, 비상벨, 일반통화라는 세 가지 사건 중 하나가 발생하면 경비센터에 어떤 연락이 통보된다. 그래서 연락의 내용이 시간에 따라 변화한다....' 라고 생각할 것이다.

```
경비시스템의 클래스 {
    금고 사용시에 호출되는 메소드(){
        if(주간){
            경비센터에 이용 기록
        }else if(야간){
            경비센터에 비상사태 통보
        }
    }
    비상벨 사용시에 호출되는 메소드() {
        경비센터에 비상벨 통보
    }
    일반 통화시에 호출되는 메소드(){
        if(주간){
            경비센터의 호출
        } else if(야간){
            경비센터의 자동응답기 호출
        }
    }
}
```



## State 패턴을 사용한 유사 코딩

```
주간 상태를 표현하는 클래스(){
    금고 사용시에 호출되는 메소드(){
        경비센터에 이용 기록
    }
    비상벨 사용시에 호출되는 메소드(){
        
    }
    일반 통화시에 호출되는 메소드(){
        경비센터의 호출
    }
}
야간 상태을 표현하는 클래스{
    금고 사용시에 호출되는 메소드(){
        경비센터에 비상상태 통보
    }
    비상벨 사용시에 호출되는 메소드(){
        경비센터에 비상벨 통보
    }
    일반 통화시에 호출되는 메소드(){
        경비센터의 자동응답기 호출
    }
}
```

두 유사 코드의 차이점은 뭘까?

사용한 코드와 사용하지 않은 코드의 차이는

State패턴을 사용한 방법에서는 상태를 클래스로 표현하고 있습니다. 상태가 클래스로 표현되어 있기 때문에 그 안의 메소드에는 **상태 검사를 위한 if문이 등장하지 않습니다.**

(1)에서는 '상태'가 메소드 안에 기술되어 있지만, (2)에서는 클래스로 기술되어 있습니다. 메소드 안에 깊숙히 묻혀있던 '상태'를 끄집어내어 외부로 표현한 모습을 파악했습니까? 그러면 (1)과 (2)를 염두에 두고 예제 프로그램을 살펴봅시다.

```
State 금고의 상태를 나타내는 인터페이스

DayState State를 구현하고 있는 클래스, 주간의 상태를 나타낸다.

NightState State를 구현하고 있는 클래스, 야간의 상태를 나타낸다.

Context 금고의 상태변환를 관리하고 경비센터와 연락을 취하는 인터페이스

StateFrame Context를 구현하는 클래스, 버튼이나 화면표시 등의 사용자 인터페이스를 갖는다.

Main 동작 테스트용 클래스
```





## State 인터페이스 (클래스에 상태를 둔다.)

State 인터페이스는 금고의 상태를 나타냅니다 .State 인터페이스는 

\- 시간이 설정되었을 때

\- 금고가 사용되었을 때

\- 비상벨이 눌렸을 때

\- 일반통화를 할 때



라는 사건에 대응해서 호출되는 인터페이스(API)를 규정하고 있습니다. 앞에서 보았던 유사 코드에서 '금고 사용시에 호출되는 메소드'등으로 표현한 것이 이 인터페이스(API)입니다. 여기에는 규정되어 있는 메소드는 모두 상태에 대응해서 처리가 변하게 됩니다. 즉, State 인터페이스는 상태의존 메소드의 집합입니다. 인수로 전될되고 있는 Context는 상태의 관리를 수행하고 있는 인터페이스



## DayState 클래스

DayState 클래스는 주간의 상태를 나타내는 클래스입니다. 이 클래스는 State인터페이스를 구현하고 있기 때문에 State인터페이스에서 선언되어 있는 메소드를 구현하고 있습니다.

상태를 나타내는 클래스는 한 개씩 인스턴스를 만든다고 가정합니다. 상태가 변화할 때마다 새로운 인스턴스를 만들게 되면, 메모리와 시간이 낭비되기 때문입니다. 따라서, 싱글톤 패턴을 사용하고 있습니다.

doClock 메소드는 시간을 설정하는 메소드입니다. 인수로 제공된 시간이 야간이면 야간의 상태로 시스템이 이행합니다. 여기에서 상태의 변화(상태전환)가 일어납니다. 여기에서는 Context 인터페이스의 changeState 메소드를 사용하여 상태의 변화를 표현하고 있습니다. 야간의 상태는 NightState 클래스에서 표현되고 그 인스턴스는 getInstance메소드에서 얻고 있습니다.(여기에서 싱글톤 패턴을 사용하고 있습니다. New nightState()로 하지 않은 점에 주의하십시오)

Douse, doAlarm, doPhone은 각각 금고 사용, 비상벨, 일반 통화에 대응한 메소드입니다. 하는 일은 Context의 메소드를 호출해서 필요한 일을 수행할 뿐입니다. 이들 메소드안에 '현재의 상태를 검사'하는 if문이 없는 점을 확인하십시오. 이 메소드들을 프로그래밍할 때 프로그래머는 항상 '현재의 주간의 상태'라는 점을 염두에 둡니다 .state패턴에서는 상태의 차이가 클래스의 차이로  표현되기 때문에, if문이나 switch문으로 상태가 변할 때마다 분기할 필요가 없습니다.

## NightState 클래스

NightState 클래스는 야간 상태를 나타내는 클래스입니다. 이것도 DayState 클래스와 마찬가지로 싱글톤 패턴을 사용하고 있습니다.



## 독자의 사고를 넓히기 위한 힌트

### 분할해서 통치해라

분할해서 통치해라(divide and conqure)하는 방심은 프로그래밍에 자주 등장. 이것은 복ㅈ바하고 규모가 큰 프로그램을 취급할 경우의 방침입니다. 규모가 크고 복잡한 문제는 그대로 해결하려고 해서는 안됩니다. 우선 문제를 작은 문제로 나눕니다. 그래도 해결하기 힘들면 더 작은 문제로 나눕니다. 문제를 간단하게 해결할 때까지 작게 나누어서 해결합니다. 크고 까다로운 문제를 하나 푸는 대신에 작고 쉬운 문제를 많이 풀어 보십시오, 분할해서 통히채라 하는 것은 간단하게 말하면 이런 것이다.

State 패턴에서는 '상태'를 클래스로 표현, 각각의 구체적인 상태를 각각의 클래스로 표현해서 문제를 분할할 것입니다. 하나의 ConcreateState 역할의 클래스를 코딩하고 있으며 프로그래머는 다른 클래스에 대한 생각을 잠시(어느 정도)잊을 수 있습니다. 에제프로그램의 금고경비 시스템과 같이 상태가 두 가지밖에 없는 경우에는 별로 필요성을 느끼지 못하겠지만, 상태가 많을 때에는 State패턴의 장점이 발휘됩니다.

> State 패턴은 시스템의 '상태'를 클래스로 표현해서 복잡한 프로그램을 분할하고 있습니다.



### 상태에 의존한 처리

SafeFrame 클래스의 setClcock 메소드와 State 인터페이스의 doClock의 관계에 대해서 생각해 봅시다.

SafeFrame 클래스의 setClcok 메소드는 Main 클래스로부터 호출되고 있습니다. Main 클래스는 setClcock 메소드를 호출해서 '시간의 설정'을 지시합니다. setClcock 메소드 안에서는 그 처리를 

> state.doClcock(this, hour);

로 state에 위임하고 있습니다. 즉, 시간의 설정을 '현재의 상태에 의존한 처리'로 취급하고 있습니다. 이것은 doClock 메소드에만 한정되지 않습니다. State 인터페이스로 선언되고 있는 메소드는 모두 '상태에 의존한 처리'이고 '상태에 따라 동작이 달라지는 처리'입니다. 이것은 당연하지만 확실히 기억해 두어야 할 포인트입니다.

State 패턴에서는 '상태에 의존한 처리'를 프로그램에서 어떻게 표현하고 있을까요? 다음의 두 가지 사항으로 정리할 수 있습니다.

\- 추상 메소드로서 선언하고 인터페이스로 한다.

\- 구상 메소드로서 구현하고 각각의 클래스로 한다.

이것이 State패턴의 '상태에 의존한처리'의 표현 방법이다.

위의 두가지 상항은 일부처 추상적으로 기술했지만 이 두 가지 사항을 읽고 금방 수궁했다면, State패턴에 대해서 그리고 인터페이스와 클래스의 관계에 대해서 확실히 이해했다고 말할 수 있습니다.

### 상태전환은 누가 관리해야 하는가?

상태를 클래스로 표현해서 상태에 의존한 동작을 각각의 ConcreteState 역할에 분담시키는 방법은 매우 좋은 방법이다. 그러나 State 패턴을 사용할 경우 **상태전환은 누가 관리해야 하는지**는 주의해야 합니다.

예제 프로그램에서는 Context역할의 SafeFrame 클래스가 상태전환을 실제로 수행하는 changeState메소드를 구현했습니다. 그러나 changeState 메소드를 실제로 호출하는 것은 ConcreateState역할의 DayState 클래스나 NightState 클래스입니다. 즉, 예제 프로그램에서\는 '상태전환'을 '상태에 의존한 동작'으로 간주하고 있습니다. 이 방버은 장점과 단점이 있다.

장점은 '다른 상태로 전환하는 것은 언제인가?'하는 정보가 하나의 클래스 내에 정리되어 있는 점입니다. 즉, 'DayState 클래스가 다른 상태로 전환하는 것은 언제인지'알고 싶을 때에는 DayState 클래스의 코드를 읽으면 됩니다.

단점은 '하나의 ConcrateState 역할이 다른 ConcreateState 역할을 알아야 한다'는 점입니다. 예를 들어 DayState 클래스는 doClcok 메소드 안에서 NightState 클래스를 사용하고 있습니다. 이것은 장래에 NightState 클래스를 삭제하고 싶을 떄 DatState클래스도 수정해야 한다는 것을 의미합니다. 상태전환을 ConcreateState 역할에 맡기면 클래스 사이의 의존관계를 깊게 합니다.



### 자기 모순에 빠지지 않는다.

State 패턴을 사용하지 않고 시스템의 상태가 복수의 변수 값의 집합으로 표현되어 있다고 가정합니다. 이때, 변수 값의 사이에 자기 모순이나 불균형이 없어야 합니다.

State 패턴에서는 상태를 클래스로 표현합니다. 현재의 상태를 나타내는 변수는 단 하나입니다 .예제 프로그램에서는 SafeFrame 클래스의 state 필드였습니다. state 필드의 값이 싯템의 상태를 확실하게 결정하기 때문에 자기 모순에 빠지지 않습니다.



### 새로운 상태를 추가하는 것은 간단하다.

State 패턴에 새로운 상태를 추가하는 것은 간단합니다. 예제 프로그램처럼 State 인터페이스를 구현한 XXXState 클래스를 만들어 필요한 메소드를 구현하면 되기 때문입니다. 단지, 상태전환의 부분은 다른 ConcreateState 역할과의 접점이 되기 때문에 주의해서 코딩할 필요가 있습니다.

그리고 완성된 State 패턴에 새로운 '상태의존의 처리'를 추가하는 것은 곤란합니다. 그것은 State역할의 인터페이스에 메소드를 추가한다는 것을 의미하며, 모든 ConcreteState 역할에 처리를 추가하는 일이 되기 때문입니다.

### 두 얼굴을 가진 인스턴스

SafeFrame 클래스 안에 등장한 다음 두 개의 문을 보아주세요

\- SafeFrame의 생성자 안 : buttonUse.addActionListener(this);

\- actionPerformed 메소드 안 : state.doUse(this)

this는 무엇? 물론, 둘 모두 SafeFrame 클래스의 인스턴스입니다. 이번 예제 프로그램에서 SafeFrame의 인스턴스느 한 개만 생성되므로 이 this는 같은 값

그러나 addActionListener에 전달될 때와 doUse에 전달될 때에는 조금 차이가 있습니다.

addActionListener 메소드에 전달될 때, **이 인스턴스는 'ActionListener 인터페이스를 구현하고 있는 클래스의 인스턴스'로 취급됩니다.** 이것은 addActionListener 메소드의 인수가 ActionListener 형이기 때문입니다. addActionListener 메소드 안에서는 'ActionListener 인터페이스에서 규정된 메소드의 범위'에서 인수가 이용됩니다. 인수로 전달된 것이 SafeFrame 의 인스턴스인지 아닌지는 중요하지 않습니다.

한편 doUse 메소드에 전달될 때, **동일한 인스턴스가 Context인터페이스를 구현하고 있는 클래스의 인스턴스로 취급됩니다.** 이것은 doUse 메소드의 인수가 Context형이기 때문입니다. doUse 메소드 안에서는 'Context'인터페이스에서 전달된 메소드의 범위에서 인수가 이용됩니다.

하





이

### 

ㅈ