/**
 * limit에서 지정한 번호 미만의 트러블을 해결하는 클래스.
 * resolve 메소드에서는 판단 후에 단지 True 값을 반환하고 있을 뿐이지만,
 * 원래는 여기에서 트러블을 '해결해 줄' 필요가 없습니다.
 */
public class LimitSupport extends Support {

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() < limit){
            return true;
        } else {
            return false;
        }
    }
}
