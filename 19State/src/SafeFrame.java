import java.awt.*;
import java.awt.event.*;

public class SafeFrame extends Frame implements ActionListener, Context {

    private TextField textClock = new TextField(60); //현재시간 표시
    private TextArea textScreen = new TextArea(10, 60);
    private Button buttonUse = new Button("금고 사용");
    private Button buttonAlarm = new Button("비상벨");
    private Button buttonPhone = new Button("일반 통화");
    private Button buttonExit = new Button("종료");

    private State state = DayState.getInstance();

    //생성자
    public SafeFrame(String title){
        super(title);

        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        //textClock 배치
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        //textScreen을 배치
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        //패널에 버튼을 저장
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);

        //그 패널을 배치
        add(panel, BorderLayout.SOUTH);

        //표시
        pack();
        show();

        //listener의 설정
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }


    @Override
    public void setClock(int hour) {
        String clcokstring = "현재 시간은";
        if(hour < 10){
            clcokstring += "0" + hour + ":00";
        } else {
            clcokstring += hour + ":00";
        }

        System.out.println(clcokstring);
        textClock.setText(clcokstring);
        state.doClock(this, hour);
    }

    //상태 전환
    public void changeState(State state){
        System.out.println(this.state + "에서" + state + "로 상태가 변화했습니다.");
        this.state = state;
    }

    //경비센터의 호출
    public void callSecurityCenter(String msg){
        textScreen.append("call! " + msg + "\n");
    }

    //경비센터의 기록
    public void recordLog(String msg){
        textScreen.append("record ... " + msg + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if(e.getSource() == buttonUse){
            state.doUse(this);
        } else if(e.getSource() == buttonAlarm){
            state.doAlarm(this);
        } else if(e.getSource() == buttonPhone){
            state.doPhone(this);
        } else if(e.getSource() == buttonExit){
            System.exit(0);
        }
    }
}
