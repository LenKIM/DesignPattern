public interface Context {
    public abstract void setClock(int hour);
    public abstract void changeState(State hour);
    public abstract void callSecurityCenter(String hour);
    public abstract void recordLog(String hour);
}
