import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
    private ArrayList observers = new ArrayList();
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void deleteObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        Iterator it = observers.iterator();
        while (it.hasNext()){
            Observer o = (Observer) it.next();
            o.update(this);
        }
    }

    public abstract int genNumber(); //수를 취득
    public abstract void execute(); // 수를 생성
}
