import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {

    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    //생성자
    //Colleague들을 생성하고, 배치한 후에 표시를 실행한다.
    public LoginFrame(String title) throws HeadlessException {
        super(title);

        setBackground(Color.lightGray);
        //레이아웃 매니저를 사용해서 4x2의 그리드를 만든다.
        setLayout(new GridLayout(4, 2));
        //Colleague들의 생성
        createColleagues();
        // 배치
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        //유효/무효의 초기 지정
        colleagueChanged();
        //표시
        pack();
        show();
    }

    //Colleague들을 생성
    @Override
    public void createColleagues() {
        //생성
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Geust", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");
        
        //Mediator의 세트
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        //Listener의 세트
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    //Colleage에서의 통지로 Colleage의 유효/무효를 판정한다.

    @Override
    public void colleagueChanged() {
        if(checkGuest.getState()){ //게스트 모드
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {
            textUser.setColleagueEnabled(true);
            userpassChange();
        }
    }

    // textUser 또는 TextPass의 변경이 있었다.
    //각 Colleague의 유효/무효를 판정한다.
    private void userpassChange() {
        if(textUser.getText().length() > 0){
            textPass.setColleagueEnabled(true);
            if(textPass.getText().length() > 0){
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }

        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(e.toString());
        System.exit(0);
    }
}
