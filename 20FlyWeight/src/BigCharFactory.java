import java.util.HashMap;

public class BigCharFactory {

    //이미 만들어진 BigChar의 인스턴스를 관리
    private HashMap<String, BigChar> hashMap = new HashMap<>();
    //싱글톤
    private static BigCharFactory singleton = new BigCharFactory();

    public BigCharFactory() {
    }

    public static BigCharFactory getInstance() {
        return singleton;
    }

    //BigChar의 인스턴스 생성(공유)
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = hashMap.get("" + charname);
        if (bc == null) {
            bc = new BigChar(charname);
            hashMap.put("" + charname, bc);
        }
        return bc;
    }
}
