public abstract class Support {
    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble){ // 트러블 해결의 수순
        if(resolve(trouble)){
            done(trouble);
        } else if( next != null){
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    protected abstract boolean resolve(Trouble trouble); // 해결용 메소드
    private void done(Trouble trouble){ // 해결
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    private void fail(Trouble trouble){ // 미해결
        System.out.println(trouble + " cannot be resolved");
    }
}
