import java.util.Scanner;
public class BlueJack {
    public static playerHand all = new playerHand(); //current game deck current color deck current players' hand cards
    public static String RESET = "\u001B[0m";

    public static int [] userBoard = {0,0,0,0,0,0,0,0,0};
    public static String [] readableUserBoard = {null,null,null,null,null,null,null,null,null};

    public static int [] computerBoard = {0,0,0,0,0,0,0,0,0};
    public static String [] readableComputerBoard = {null,null,null,null,null,null,null,null,null};

    public static int userTotal=0;
    public static int computerTotal=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to BLUEJACK");
        System.out.println("PRESS 0 to START");
        while (true) {
            int start = sc.nextInt();
            if (start == 0) {

                System.out.println("Player's hand cards are being given...");
                System.out.println("Your cards : ");
                for (int i = 0; i < all.readableUserHand.length; i++) {
                    System.out.print(all.readableUserHand[i] + ", ");
                }
                System.out.println("Cards are ready. You can call now.");
                break;
            } else {
                System.out.println("Until you press 0, the game will not start.");
            }
        }
        switchs();
    }
    public static void switchs(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("PRESS 1 TO CALL A CARD \nPRESS 2 TO HOLD \nPRESS 3 TO RESTART");
            int press = sc.nextInt();
            switch (press) {
                case 1:
                    call();
                    break;
                case 2:

                    continue;
                case 3:

                    break;

            }
        }
    }
    public static int i=0;
    public static void call(){
        Scanner sc = new Scanner(System.in);
        if(userTotal<20){
            userTotal+=all.currentGameDeck[i];
            userBoard[i]=all.currentGameDeck[i];
            readableUserBoard[i]=all.currentColorDeck[i]+userBoard[i]+RESET;
            System.out.println("Your call -> " +readableUserBoard[i]);
            System.out.println("Your total -> " +userTotal);
            System.out.println("IF YOUR WANT \nPRESS 1 TO USE SPECIAL CARD \nPRESS 0 TO PASS");
            int press = sc.nextInt();
            if(press==1){
                
            }
            i++;
            if(userTotal==20){
                System.out.println("Wait for the computer's move.");
            }
            else if(userTotal>20){
                System.out.println("You lose!");
                sc.close();
            }
            computerCall();
            switchs();
        }
    }

    public static void computerCall(){
        if(computerTotal<20){
            computerTotal+=all.currentGameDeck[i];
            computerBoard[i]=all.currentGameDeck[i];
            readableComputerBoard[i]=all.currentColorDeck[i]+computerBoard[i]+RESET;
            i++;
            if(computerTotal==20 && userTotal!=20){
                System.out.println("COMPUTER WINS!!");
            }
            else if(computerTotal==20){
                System.out.println("DRAW!! No one wins!");
            }
            else if(computerTotal>20){
                if(userTotal<20) {
                    System.out.println("YOU WIN!!!");
                }
            }
        }
    }
}








