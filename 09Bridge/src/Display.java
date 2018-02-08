/**
 * 기능의 클래스 계층
 */
public class Display {

    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }
//open / print / close를 직접 타이핑
    public void open(){
        impl.rawOPen();
    }

    public void print(){
        impl.rawPrint();
    }

    public void close(){
        impl.rawClose();
    }

    public final void display(){
        open();
        print();
        close();
    }


}
