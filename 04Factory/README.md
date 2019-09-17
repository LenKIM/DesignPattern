템플릿 메서드는 상위클래스에서 처리의 골격을 만들고, 하위 클래스에서 구체적인 처리의 내용을 만들었습니다.
이 패턴을 인스턴스 생성의 장면에 적용한 것이 바로 **팩토리패턴**입니다.


# 인스턴스 생성하는 공장.

인스턴스 생성의 framework 측
구체적인 내용을 구현하고 있는 측


![factory](https://i.imgur.com/fvj9MNI.jpg)

Creator와 Product

이 부분이 framework

idCard부분도

ConcreateCreator 와 ConcreateProduct

Creator(작성자)의 역할
Product역할을 생성하는 추상클래스는 프래임워크쪽에 가깝습니다
구체적인 내용은 하위클래스의 ConcreateCreator 역할이 결정합니다 예제 프로그램에서는 Factory클래스가 이 역할을 합니다.

Creator역할은 실제로 생성하는 ConcreateProduct역할에 가지고 있는 정보가 없습니다.
Creator 역할이 가지고 있는 정보는 Product 역할과 인스턴스 생성의 메소드를 호출하면 Product 가 생성된다는 것뿐 예제 프로그램에서는 createProduct 메소드가 인스턴스 생성을 위한 메소드가 됩니다

**new를 사용해서 실제의 인스턴스를 생성하는 대신에, 인스턴스 생성을 위한 메소드를 호출해서 구체적인 클래스 이름에 의한 속박에서 상위 클래스를 자유롭게 만듭니다.**

#### 인스턴스 생성 - 메소드의 구현 방법

예제 프로그램에서 Factory 클래스의 CreateProduct 메소드는 추상 메소드이며 하위 클래스에서 구현하게 됩니다
createProduct 메소드의 기술 방법은 다음과 같이 세 가지로 생각할 수 있습니다.

1. 추상메서드로한다.
추상 메서드로 하면 하위 클래스는 반드시 이 메소드를 구현해야 합니다. 구현되어 있지 않으면 컴파일할 때 검출됩니다. 예제 프로그램에서는 이 방법을 이용합니다

2. 디폴트의 구현을 준비해 둔다.
디폴트의 구현을 준비하는 방법입니다. 디폴트의 구현을 준비해 두고 하위 클래스에서 구현하지 않았을 때 사용하면 됩니다.
```java
 class Factory{
 public Product createProduct(String name){
 return new Product(name);
 }
```

3. 에러를 이용한다.
디폴트의 구현 내용을 에러로 처리해 두면, 하위 클래스에서 구현하지 않았을 경우에는 실행할 때 에러가 발생합니다.
```java
 class Factory{
 public Product createProduct(String name){
 throw new FactoryMethodRuntimeException();
 }
```

#### 패턴 이용과 개발자 간의 의사 소통



