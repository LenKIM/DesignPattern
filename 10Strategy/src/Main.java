import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seed1 = Integer.parseInt(br.readLine());
        int seed2 = Integer.parseInt(br.readLine());

        Player player1 = new Player("두리", new WinningStrategy(seed1));
        Player player2 = new Player("하나", new ProbStrategy(seed2));

        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if(nextHand1.isStrongerThan(nextHand2)){
                System.out.println("Winnder:" + player1);
                player1.win();
                player1.lose();
            } else if(nextHand2.isStrongerThan(nextHand1)){
                System.out.println("Winnder:" + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }
        System.out.println("Total result");
        System.out.println(player1.toString());
        System.out.println(player2.toString());

    }
}
