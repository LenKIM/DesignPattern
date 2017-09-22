/**
 * Builder 클래스로 선언되어 있는 메소드를 사용해 문서를 만듬
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) { //Builder 의 하위 클래스의 인스턴스가 주어지므로 Builder 필드에 저장해 둔다.
        this.builder = builder;
    }

    public void construct(){ // 문서 구축
        builder.makeTitle("Greeting"); // 타이틀
        builder.makeString("아침과 낮에"); // 문자열
        builder.makeItems(new String[]{ // 개별 항목
                "좋은 아침입니다.",
                "안녕하세요.",
        });
        builder.makeString("밤에"); // 별도의 ㅁ누자열
        builder.makeItems(new String[]{
                "안녕하세요.",
                "안녕히 주무세요.",
                "안녕히 계세요."
        });
        builder.close();
    }


}
