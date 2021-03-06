     Abstract 는 '추상적인' 이라는 의미이고, Factory는 '공장'이라는 의미입니다.

일반적으로 생각해보면 추상적이라는 단어와 공장이라는 단어는 별로 연관성이 없어 보인다. 공장이라면 부품을 조립해서 제품을 만드는 장소이기 때문에, 하고 있는 일이 매우 구체적일 것입니다.

그럼 대체 '추상적인 공장'이란 무엇을 뜻할까?

'Abstract Factory'에서는 '추상적인 공장' 뿐만 아니라 '추상적인 부품'도 등장하기 때문에.

`추상적인 공장에서는 추상적인 부품을 조합해서 추상적인 제품을 만듭니다.`



Abstract Factory 패턴에서는 추상적인 공장이 등장하고, 추상적인 부품을 조합해서 추상적인 제품을 만듭니다. 즉, **부품의 구체적인 구현에는 주목하지 않고 인터페이스(API)에 주목합니다. 그리고 인터페이스(API)만을 사용해서 부품을 조힙하고 제품으로 완성합니다.**



Template Method 패턴이나 Build 패턴에서는 하위 클래스의 레벨에서 구체적인 구현을 실행했습니다. Abstract Factory패턴에서도 하위 클래스 단계에서 구체적인 구현을 실행합니다. 하위 클래스단계에서는 구체적인 공장이 등장하고 구체적인 부품을 조합해서 구체적인 제품을 만드립니다.



다음 예제를 봅시다. '계층 구조를 가진 Link 페이지를 HTML파일로 만들기'입니다.

이 예제는 3개의 패키지로 분리된 클래스군으로 구성되어 있습니다.

Factory 패키지 : 추상적인 공장 - 부품 - 제품을 포함한 패키지

Anonymous 패키지 : Main 클래스를 포함한 패키지

listFactory 패키지 : 구체적인 공장 - 부품 - 제품을 포함한 패키지.
아래 예시에서는 ul 태그를 사용해서 구현

특이하다고 할 수 있는 것은 지금까지 예제 프로그램에서는 Main.java 컴파일하면 필요한 클래스가 전부 컴파일 되었지만, 이번 예제 프로그램에서는 Main.java 를 컴파일하면 Factory.java, Item.java, Link.java, Tray.java, Page.java는 컴파일되지만, ListFactory.java ListLink.java, ListTray.java, ListPage.java는 컴파일 되지 않습니다. 그 이유는 Main 클래스는 Factory 패키지만을 사용하고 listfactory는 직접 사용하지 않기 때문입니다.



#### 사고 넓히기

### 구체적인 공장을 새로 추가하는 것은 간단하다.

Abstract Factory 패턴에 구체적인 공장을 새로 추가하는 것은 간단하다. '간단'하다는 의미는 어떤 클래스를 만들고, 어떤 메소드를 구현하면 좋은지가 확실하다는 의미이다. 예를 들어, 예제 프로그램에 다시 새로운 구체적인 공장을 추가한다고 가정합시다. 해야 할 일은 Factory, Link, Tray, Page의 하위 클래스를 만들고 각각의 추상 메소드를 구현하는 일입니다. 즉, Factory패키지의 클래스가 가지고 있는 추상적인 부분을 구체화 해가는 일입니다. 이때 아무리 구체적인 공장을 추가해도(또 구체적인 공장의 버그를 수정해도) 추상적인 공장이나 Main부분을 수정할 필요는 전혀 없습니다.

### 부품을 새로 추가하는 것은 곤란하다.

Abstract Factory 패턴에 새로 부품을 추가하는 일에 대해 생각해 봅시다. 예를 들어 factory 패키지에 화상을 표시하는 Picture라는 부품을 추가했다고 가정합니다. 그러면 이미 존재하는 구체적인 공장 전부에 Picture에 대응하는 수정을 해야 합니다. 예를 들어 listfactory 패키지라면 

- ListFactory 클래스에 createPicture 메소드를 추가
- 새롭게 ListPicture클래스를 작성

하는 수정을 해야 합니다. 이미 만들어진 구체적인 공장이 많으면 많을 수록 고된 작업이 될 수 있습니다.



## 보강 - 인스턴스를 만드는 다양한 방법



자바에서 다음과 같이 인스턴스를 만드는 방법이 있습니다.

### new

일반적으로 인스턴스는 Java의 예약어 new를 사용해 만듬

### clone

프로토타입 패턴에서 등장했던 clone메소드를 사용하면 이미 존재하는 인스턴스를 기초로 새로운 인스턴스를 만들 수 있습니다. 다음과 같이 하면 자신(this)을 기초로 새로운 인스턴스를 만들 수 있습니다.(단, 생성자는 호출하지 않습니다.)



### newinstance

이 장에 등장한 java.lang.Class 클래스의 newInstance 메소드를 사용하면 Class의 인스턴스를 기초로 그 Class가 표시하고 있는 클래스의 인스턴스를 만들 수 있습니다.(인수 없는 생성자가 호출)