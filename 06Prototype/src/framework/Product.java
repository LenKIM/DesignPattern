package framework;

/**
 * Product 클래스는 Cloneable 인터페이스를 상속하고 있으며 복제가 가능합니다.
 * 이 인터페이스를 구현하고 있는 클래스의 인스턴스는
 * clone 메서드를 사용하여 자동적으로 복제할 수 있습니다.
 *
 * use 메서드는 '사용하기'위한 것입니다. '사용하기'가 무엇을 의미하는지는 하위 클래스의 구현에 맡겨져 있습니다.
 * createClone 메서드는 인스턴스를 복제하기 위한 것.
 *
 */
public interface Product extends Cloneable {
    public abstract void use(String s);
    public abstract Product createClone();
}
