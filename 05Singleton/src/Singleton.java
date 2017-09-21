public class Singleton {
    private static Singleton singleton =null;

    private Singleton() {
        System.out.println("인스턴스 생성됨");
    }

    public static synchronized Singleton getSingleton() {
        if(singleton == null)
            singleton = new Singleton();
        return singleton;
    }
//    위의 조건에 대한 취약점은 여러 쓰레드를 만들 때 스레드세이프가 아니기 때문이다. 그럼 어떻게?? 바로 synchronized 를 활용
}

/**
 * 왜 위에 싱글톤은 엄밀히 말하면 싱글톤이 아닐까??? 바로 쓰레드의 활용때문이다.
 * 위와 같이 동작시 다중의 쓰레드에서는 다중 인스턴스를 생성될 가능성이 있다.
 *
 */

class Main extends Thread{

    public Main(String name) {
        super(name);
        System.out.println("인스턴스를 생성");
    }

    public static void main(String[] args) {
        System.out.println("start");
        new Main("A").start();
        new Main("B").start();
        new Main("C").start();
        System.out.println("End");
    }

    @Override
    public void run() {
        Singleton obj = Singleton.getSingleton();
        System.out.println(getName() + " : obj =" + obj);
    }
}
