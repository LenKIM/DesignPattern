/**
 * '중개인'을 표현하는 인터페이스. 구체적인 중개인은 이 인터페이스를 구현합니다.
 * createColleagues메소드는 Mediator가 관리하는 회원을 생성하는 메소드입니다.
 * 예제 프로그램에서는 createColleagues 메소드에서 필요한 버튼이나 텍스트 필드 등을 작성합니다.
 * colleagueChanged 메소드에서 필요한 버튼이나 텍스트 필드 등을 작성합니다.
 */
public interface Mediator {
    public abstract void createColleagues();
    public abstract void colleagueChanged();
}
