public interface Builder {
    public void makeTitle(String title);
    public void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();
}
