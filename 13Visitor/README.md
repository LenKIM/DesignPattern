## VISITOR 패턴

1. Visitor(방문자)의 역할  
   ​
   Visitor는 데이터 구조의 구체적인 요소(ConcreateElement 역할)마다 'xxxx을 방문했다'라는 visit(xxxx)메소드를 선언합니다. visit(xxxx)는 xxxx을 처리하기 위한 메소드이고, 실제의 코드는 ConcreateVisitor 역할에 기술되어 있다.
   예제에서는 Visitor클래스가 이 역할을 수행
   ​

2. ConcreateVisitor(구체적인 방문자)역할  
   ​

   ConcreateVisitor(구체적인 방문자)는 Visitor 역할의 인터페이스(API) 구현합니다. visit(xxx)라는 형태의 메소드를 구현하고, 각각의 ConcreateElement 역할의 처리를 기술합니다. 예제 프로그램에서는 ListVisitor 클래스가 이 역할을 합니다. ListVisitor에서 currentdir 필드값이 변화했듯이 visit를 처리해 가는 중에 ConcreateVisitor 역할의 내부상태가 변화하는 일도 있습니다.

   ​

3. Element(요소)의 역할  
   ​

   Element는 Visitor 역할의 방문할 곳을 나타내는 역할로, 방문자를 받아들이는 accept 메소드를 선언합니다. Accept 메소드의 인수에는 Visitor 역할이 전달됩니다. 예제 프로그램에서는 Element 인터페이스가 이 역할을 합니다.
   ​

4. ConcreteElement(구체적 요소)의 역할   
   ​

   ConcreateElement는 Element역할의 인터페이스를 구현하는 역할 예제에서는 File이나 Directory 클래스가 이 역할을 수행.

   ​

5. ObjectStructure(오브젝트의 구조)의 역할  
   ObjectStructure는 element역할의 집합을 취급하는 역할, ConcreateVisitor 역할이 각각의 Element역할을 취급할 수 있는 메소드를 구비하고 있습니다. 예제 프로그램에서는 Directory 클래스가 이 역할을 합니다.(1인 2역) ConcreateVisitor 역할이 각각의 Element 역할을 취급할 수 있는 것처럼 예제 프로그램의 Directory 클래스에는 iterator 메소드가 준비되어 있습니다.
   ​





![](http://img1.daumcdn.net/thumb/R1920x0/?fname=http%3A%2F%2Fcfile3.uf.tistory.com%2Fimage%2F1622A13550192C7A07C984)

https://www.slideshare.net/madvirus/visitor-1201213

![http://img1.daumcdn.net/thumb/R1920x0/?fname=http%3A%2F%2Fcfile5.uf.tistory.com%2Fimage%2F2446D8435834EE5D3396E8](http://img1.daumcdn.net/thumb/R1920x0/?fname=http%3A%2F%2Fcfile5.uf.tistory.com%2Fimage%2F2446D8435834EE5D3396E8)

## 독자의 사고를 넓히기 위한 힌트

### 1. 더블 디스패치(double dispatch)

​	Visitor 패턴에서의 메소드 호출을 정리하면 accept(받아 들이다) 메소드는 다음과 같이 호출됩니다.
​	`element.accept(Visitor)`

​	한편, visit(방문) 메소드는 다음과 같이 호출됩니다.
​	`visitor.visit(element)`

​	이 두가지를 비교해 보면 정확히 반대의 관계에 있음을 알 수 있습니다. element는 visitor를 accept하고, visitor는 element를 visit하고 있습니다.

Visitor 패턴에서는 ConcreateElement 역할과 ConcreteVisitor 역할을 하는 한 쌍에 의해 실제 처리가 결정됩니다. 이것을 일반적으로 **더블 디스패치(double dispatch : 이중 분리)**라고 합니다.

### 2. 왜 이렇게 복잡한 일을 하는가?

처리의 흐름이 이해될 때까지 'Visitor 패턴은 이야기를 복잡하게 만들고 있을 뿐이잖아' 하고 느낄지도 모릅니다. '반복 처리가 필요' 하면 데이터 구조 안에 루프를 사용하면 되지 어쨰서 accept나 visit 같은 복잡한 메소드를 호출해야 하지? 라는 생각을 가질 수도 있습니다.

Visitor 패턴의 목적은 **처리를 데이터 구조에서 분리하는 일**입니다. 데이터 구조는 요소를 집합으로 정리하거나, 요소 사이를 연결해주는 중요한 역할을 합니다. 그러나 구조를 유지하는 것과 구조를 기초로 한 처리를 기술하는 것과는 별개입니다.

예제 프로그램에서는 종류 표시라는 처리를 실행하는 ConcreateVisitor 역할로서 ListVisitor 클래스를 만들었습니다. 또, 연습문제에서는 다른 처리를 실행하는 ConcreateVisitor 역할을 만듭니다. 일반적으로 ConcreateVisitor 역할은 File클래느ㅏ Directory 클래스와는 독립적으로 개발할 수 있습니다.

즉, Visitor 패턴은 File 클래스나 Directory 클래스의 부품으로써의 독립성을 높일 수 있습니다. 만약, 처리 내용을 File 클래스나 Directory 클래스의 메소드로서 프로그램을 작성하면, 새로운  '처리'를 추가해서 기능 확장을 할 때마다 File 클래스나 Directory클래스를 수정해야 합니다.

### 3. The Open-Closed Principle - 확장에 대해서는 열고, 수정에 대해서는 닫는다.

기능 확장과 수정에 대한 이야기에서

확장에 대해서는 열려 있고, 수정에 대해서는 닫혀있어야 한다.

클래스를 설계할 때 특별한 이유가 없는 한 확장을 허용해야 한다. 이유 없이 확장을 금지해서는 안되며, 이것이 '확장에 대해서는 열려있다'라는 의미입니다.

그러나 확장을 할 때마다 기존의 클래스를 수정해야 하는 것도 곤란합니다. 확장을 해도 기존의 클래스는 수정할 필요가 없는 것ㅇ; '수정에 대해서는 닫혀있다'라는 의미입니다.

### 4. ConcreateVisitor 역할의 추가는 간단하다.

### 5. ConcreateElement 역할의 추가는 곤란하다.

만약, device라는 클래스를 생성하면 Visitor 클래스의 하위 클래스 전부에 새로운 visitor 메소드를 구현해야 합니다.

### 6. Visitor가 처리하기 위해서는 무엇이 필요한가?


더블패치에 대한 간략한 참조 사이트
[https://jinwooe.wordpress.com/2017/01/29/더블-디스패치/amp/](https://jinwooe.wordpress.com/2017/01/29/더블-디스패치/amp/)

