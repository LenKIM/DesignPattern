import java.awt.*;

public class ColleagueButton extends Button implements Colleague {

    private Mediator mediator;

    public ColleagueButton(String label) {
        super(label);
    }

    public void setMediator(Mediator mediator) {         //Mediator를 저장
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) { // Mediator에서 유효/무효를 지시
        setEnabled(enabled);
    }
}
