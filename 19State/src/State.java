public interface State {
    public abstract void doClock(Context context, int hour); //시간설정
    public abstract void doUse(Context context); //시간설정
    public abstract void doAlarm(Context context); //시간설정
    public abstract void doPhone(Context context); //시간설정
}
