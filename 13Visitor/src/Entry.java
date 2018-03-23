import java.util.Iterator;

/**
 * 앞에서 컴포싯패턴과 본질은 같지만, Entry를 구현함으로써, visitor 패턴에 적용
 */
public abstract class Entry implements Element {

    public abstract String getName(); // 이름
    public abstract int getSize(); // 사이즈


    public Entry add(Entry entry) throws FileTreatmentExection {
        throw new FileTreatmentExection();
    }

    public Iterator iterator()throws FileTreatmentExection{ // 이터레이터 생성
        throw new FileTreatmentExection();
    }

    @Override
    public String toString() {
        return getName() + " ( " + getSize() + ")";
    }
}
