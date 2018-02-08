public class Player {
    private String name;
    private Strategy strategy;
    private int wincount;
    private int losecount;
    private int gamecount;

    public Player(String name, Strategy strategy) { // 이름과 전략을 할당받는다.
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand(){ //전략의 지시를 받는다.
        return strategy.nextHand();
    }

    public void win(){
        strategy.study(true); // 승
        wincount++;
        gamecount++;
    }

    public void lose(){
        strategy.study(false);
        losecount++;
        gamecount++;
    }

    public void even(){
        gamecount++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", wincount=" + wincount +
                ", losecount=" + losecount +
                ", gamecount=" + gamecount +
                '}';
    }
}
