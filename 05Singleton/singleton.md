# 인스턴스를 한 개만 만들기.

프로그램을 실행할 때 보통은 많은 인스턴스가 생성됩니다 예를 들어 문자열을 표시하는 String클래스의 인스턴스는 문자열 1개에 대해서 1개가 생성되기 때문에
문자열이 1000개라면 1000개의 인스턴스 생성됩니다.

그러나 **'클래스의 인스턴스가 단 하나만 필요'** 한 경우도 있습니다.
그것은 시스템 안에서 1개밖에 존재하지 않는 것을 프로그램으로 표현하고 싶을 때입니다.
예를 들어 컴퓨터 자체를 표현한 클래스, 현재의 시스템 설정을 표현한 클래스 원도우 시스템을 표현한 클래스 등입니다.

물론 주의를 기울여 프로그래밍해서 new MyClass()가 1회만 실행되도록 작성하면 단 1개만 생성됩니다.
그러나 '주의가 아닌 보증을 하기위해서는 싱글톤'

### Singleton 클래스

싱글톤 클래스의 생성자는 항상 private 되어 있습니다 이것은 Singleton 클래스 외부에서 생성자의 호출을 금지하기 위해서 입니다.

여기에서는 동작의 상태를 확인하기 위해 생성자 안에서 '인스턴스를 생성했습니다'라는 메시지를 표시하고 있습니다.
Singleton 클래스의 유일한 인스턴스를 얻는 메소드로서 getInstance가 준비되어 있습니다. 예제 프로그램에서는 메서드 이름을 getInstance로 했지만 반드시 이 이름일 필요는 없습니다.

```java
 public class Singleton{
    private static Singleton singleton = new Singleton();
    private Singleton(){

    }
    <!--  생성자를 private로 만드는 것이 핵심-->
    public static Singleton getInstance(){
    return singleton;
    }
 }
```

 인스턴스가 하나밖에 생성되지 않는 것을 보증하는 Singleton 패턴
 이와 유사한 패턴으로
 - Abstract Factory
 - Builder 패턴
 - Facade 패턴
 - Prototype 패턴






