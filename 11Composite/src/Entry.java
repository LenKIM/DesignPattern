public abstract class Entry {


    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix); // prefix를 앞에 붙여서 종류를 표시한다.

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
