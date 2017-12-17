package factory;

/**
 * getFactory 안에서는 Class클래스의 forName 메소드를 사용하여,
 * 그 클래스의 인스턴스르를 한 개 작성합니다.
 * 이것이 getFactory의 반환값이 될 것입니다.
 *
 * Class 클래스는 java.lang 패키지에 속하는 클래스로서 '클래스를 표현하는 클래스'입니다.
 * Class 클래스는 Java의 표준 라이브러리에 포함
 * forName은 java.lang.Class의 클래스 메소드(Static 메소드)이고, newInstance는 Java.lang.Class의 인스턴스 메소드
 *
 * getFactory 메소드의 안에서는 구체적인 고장의 인스턴스를 만들지만,
 * 반환값은 추상적인 공장이라는 점을 주의
 *
 * 각각의 메소드는 그 추상적인 공장에서 부품이나 제품을 작성할 때 이용하는 메소드
 * 이것은 모두 추상 메소드로 되어 있고, 실제의 구체적인 부품이나 제품의 작성은 Factory의 하위 클래스에게 맡긴다.
 * 단, 메소드의 이름과 시그니처만은 확실히 정해져 있습니다.
 */
public abstract class Factory {
    public static Factory getFactory(String classname){
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(classname).newInstance();

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("클래스 " + classname + " 이 발견되지 않았습니다.");
            e.printStackTrace();
        }
        return factory;
    }
    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
}
