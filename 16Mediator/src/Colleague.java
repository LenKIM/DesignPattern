/**
 * 중개인에게 상담을 의뢰하는 회원을 나타내는 인터페이스입니다.
 * 구체적인 회원(ColleagueButton, ColleagueTextField, ColleagueCheckbox)은 이 인터페이스를 구현합니다.
 *
 * setMediator 메소드는 Mediator 인터페이스를 구현한 LoginFrame클래스가 최초로 호출하는 메소드
 * => '내가 중개인이니까 기억해 두십시오' 하는 메소드. 이 메소드의 인수로 전달된 인스턴스는 나중에 상담이 필요해질 때(colleagueChanged를 호출할 때)사용합니다.
 *
 * setColleagueEnabled 메소드는 중개인이 내리는 '지시'에 해당. 인수 enabled가 true이면 자기자신을 '유효상태'로 하고, false이면 자기자신을 '무효상태'로 합니다.
 * 이 메소드는 자신이 '유효상태'로 되어야 하는지 '무효상태'로 되어야 하는지 스스로 판단하는 것이 아니라, 중개인의 판단에 따라서 결정된다는 것을 나타내고 있습니다.
 *
 */
public interface Colleague {

    public abstract void setMediator(Mediator mediator);
    public abstract void setColleagueEnabled(boolean enabled);

}
