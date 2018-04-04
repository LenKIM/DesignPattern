import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox  extends Checkbox implements ItemListener {
    private Mediator mediator;

    public ColleagueCheckbox(String label, CheckboxGroup group, boolean state) throws HeadlessException {
        super(label, group, state);
    }

    public void setMediator(Mediator mediator){ // Mediator 를 저장
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled){
        setEnabled(enabled); // Mediator에서 유효/무효를 지시
   }
    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();
        //상태가 바뀌면 Mediaotr에게 통지
    }
}
