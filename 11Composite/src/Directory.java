import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry { // 디렉터리를 표현하는 클래스이며 Entry클래스의 하위 클래스로 정
    private String name;
    private ArrayList<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()){
            Entry entry = it.next();
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry){
        directory.add(entry);
        return this;
    }

    @Override
    public void printList(String profix) {
        System.out.println(profix + "/" + this);
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()){
            Entry entry = it.next();
            entry.printList(profix + "/" + name);
        }
    }
}
