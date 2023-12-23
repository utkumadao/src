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

    public static boolean gameIsRunning = true;
    public static boolean hold = true;

    public static void main(String[] args) {
        while(gameIsRunning){
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to BLUEJACK");
            System.out.println("PRESS 0 to START");
            while (true) {
                String start = sc.nextLine();
                if (start.equals("0")){

                    System.out.println("Player's hand cards are being given...");
                    System.out.println("Your cards : ");
                    for (int i = 0; i < all.readableUserHand.length; i++) {
                        System.out.print(all.readableUserHand[i] + ", ");
                    }
                    System.out.println("Cards are ready. You can call now.");
                    break;
                }
                else {
                    System.out.println("Until you press 0, the game will not start.");
                }
            }
            switches();
        }
    }
    public static void switches(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("PRESS 1 TO CALL A CARD \nPRESS 2 TO HOLD \nPRESS 3 TO RESTART");
            int press = sc.nextInt();
            switch (press) {
                case 1:
                    call();
                    break;
                case 2:
                    hold=false;
                    hold();
                    continue;
                case 3:
                    restart(0, 0);
                    break;

            }
        }
    }

    public static int i=0;
    public static void call(){
        Scanner sc = new Scanner(System.in);

        if(userTotal<20) {
            userTotal += all.currentGameDeck[i];
            userBoard[i] = all.currentGameDeck[i];
            readableUserBoard[i] = all.currentColorDeck[i] + userBoard[i] + RESET;
            System.out.println("Your call -> " + readableUserBoard[i]);
            System.out.println("Your total -> " + userTotal);
            System.out.println("\nYour board cards");
            for (int i = 0; i < all.readableUserHand.length; i++) {
                System.out.print(all.readableUserHand[i] + ", ");
            }
            System.out.println("\n\nComputer's total -> " + computerTotal);
            System.out.println("\n--------------");
            System.out.println("\nIF YOU'D LIKE \nPRESS 1 TO USE A HAND CARD \nPRESS 0 TO PASS");
            String press = sc.nextLine();
            if (press.equals("1")) {
                System.out.println("Your hand cards -> ");
                for (int i = 0; i < all.readableUserHand.length; i++) {
                    System.out.println(i + 1 + ". " + all.readableUserHand[i] + ", ");
                }
                System.out.println("Which one would you like to play? \nIf you want to quit PRESS 0");
                while (true) {
                    int which = sc.nextInt();
                    switch (which) {
                        case 0:
                            i++;
                            break;
                        case 1:
                            if (all.userHand[0] == 100) {
                                if (userBoard[which - 1] != 101) {
                                    userTotal += all.currentGameDeck[i];
                                    i++;
                                    userBoard[i] = 100;//it is not necessary but I want to add it
                                    readableUserBoard[i] = "x2";
                                    all.userHand[which - 1] = 0;
                                    all.readableUserHand[which - 1] = null;
                                    System.out.println("Your total -> " + userTotal);
                                    computerCall();
                                    break;
                                }
                                else {
                                    System.out.println("Choose another card!!");
                                }
                            }
                            else if (all.userHand[0] == 101) {
                                if (userBoard[i] != 100) {
                                    userTotal += -1 * userBoard[i];
                                    i++;
                                    userBoard[i] = 101;
                                    readableUserBoard[i] = "+/-";
                                    all.userHand[which - 1] = 0;
                                    all.readableUserHand[which - 1] = null;
                                    System.out.println("Your total -> " + userTotal);
                                    computerCall();
                                    break;
                                }
                                else {
                                    System.out.println("Choose another card!!");
                                }
                            }
                            else if (all.userHand[0] == 0) {
                                System.out.println("This slot does not have a card. Please choose another slot.");
                            }
                            else {
                                if (userBoard[i] != 100 || userBoard[i] != 101) {
                                    userTotal += all.userHand[which - 1];
                                    i++;
                                    userBoard[i] = all.userHand[which - 1];
                                    readableUserBoard[i] = all.readableUserHand[which - 1];
                                    all.userHand[which - 1] = 0;
                                    all.readableUserHand[which - 1] = null;
                                    System.out.println("Your total -> " + userTotal);
                                    computerCall();
                                    break;
                                }
                            }
                        case 2:
                            if (all.userHand[0] == 100) {
                                if (userBoard[which - 1] != 101) {
                                    userTotal += all.currentGameDeck[i];
                                    i++;
                                    userBoard[i] = 100;//it is not necessary but I want to add it
                                    readableUserBoard[i] = "x2";
                                    all.userHand[which - 1] = 0;
                                    all.readableUserHand[which - 1] = null;
                                    System.out.println("Your total -> " + userTotal);
                                    computerCall();
                                    break;
                                }
                                else {
                                    System.out.println("Choose another card!!");
                                }
                            }
                            else if (all.userHand[0] == 101) {
                                if (userBoard[i] != 100) {
                                    userTotal += -1 * userBoard[i];
                                    i++;
                                    userBoard[i] = 101;
                                    readableUserBoard[i] = "+/-";
                                    all.userHand[which - 1] = 0;
                                    all.readableUserHand[which - 1] = null;
                                    System.out.println("Your total -> " + userTotal);
                                    computerCall();
                                    break;
                                }
                                else {
                                    System.out.println("Choose another card!!");
                                }
                            }
                            else if (all.userHand[1] == 0) {
                                System.out.println("This slot does not have a card. Please choose another slot.");
                            }
                            else {
                                if (userBoard[i] != 100 || userBoard[i] != 101) {
                                    userTotal += all.userHand[which-1];
                                    i++;
                                    userBoard[i] = all.userHand[which - 1];
                                    readableUserBoard[i] = all.readableUserHand[which - 1];
                                    all.userHand[which - 1] = 0;
                                    all.readableUserHand[which - 1] = null;
                                    System.out.println("Your total -> " + userTotal);
                                    computerCall();
                                    break;
                                }
                            }
                        case 3:
                            if (all.userHand[0] == 100) {
                                if (userBoard[which - 1] != 101) {
                                    userTotal += all.currentGameDeck[i];
                                    i++;
                                    userBoard[i] = 100;//it is not necessary but I want to add it
                                    readableUserBoard[i] = "x2";
                                    all.userHand[which - 1] = 0;
                                    all.readableUserHand[which - 1] = null;
                                    System.out.println("Your total -> " + userTotal);
                                    computerCall();
                                    break;
                                }
                                else {
                                    System.out.println("Choose another card!!");
                                }
                            }
                            else if (all.userHand[0] == 101) {
                                if (userBoard[i] != 100) {
                                    userTotal += -1 * userBoard[i];
                                    i++;
                                    userBoard[i] = 101;
                                    readableUserBoard[i] = "+/-";
                                    all.userHand[which - 1] = 0;
                                    all.readableUserHand[which - 1] = null;
                                    System.out.println("Your total -> " + userTotal);
                                    computerCall();
                                    break;
                                }
                                else {
                                    System.out.println("Choose another card!!");
                                }
                            }
                            else if (all.userHand[2] == 0) {
                                System.out.println("This slot does not have a card. Please choose another slot.");
                            }
                            else {
                                if (userBoard[i] != 100 || userBoard[i] != 101) {
                                    userTotal += all.userHand[which - 1];
                                    i++;
                                    userBoard[i] = all.userHand[which - 1];
                                    readableUserBoard[i] = all.readableUserHand[which - 1];
                                    all.userHand[which - 1] = 0;
                                    all.readableUserHand[which - 1] = null;
                                    System.out.println("Your total -> " + userTotal);
                                    computerCall();
                                    break;
                                }
                            }
                        case 4:
                            if (all.userHand[0] == 100) {
                                if (userBoard[which - 1] != 101) {
                                    userTotal += all.currentGameDeck[i];
                                    i++;
                                    userBoard[i] = 100;//it is not necessary but I want to add it
                                    readableUserBoard[i] = "x2";
                                    all.userHand[which - 1] = 0;
                                    all.readableUserHand[which - 1] = null;
                                    System.out.println("Your total -> " + userTotal);
                                    computerCall();
                                    break;
                                }
                                else {
                                    System.out.println("Choose another card!!");
                                }
                            }
                            else if (all.userHand[0] == 101) {
                                if (userBoard[i] != 100) {
                                    userTotal += -1 * userBoard[i];
                                    i++;
                                    userBoard[i] = 101;
                                    readableUserBoard[i] = "+/-";
                                    all.userHand[which - 1] = 0;
                                    all.readableUserHand[which - 1] = null;
                                    System.out.println("Your total -> " + userTotal);
                                    computerCall();
                                    break;
                                }
                                else {
                                    System.out.println("Choose another card!!");
                                }
                            }
                            else if (all.userHand[3] == 0) {
                                System.out.println("This slot does not have a card. Please choose another slot.");
                            }
                            else {
                                if (userBoard[i] != 100 || userBoard[i] != 101) {
                                    userTotal += all.userHand[which];
                                    i++;
                                    userBoard[i] = all.userHand[which - 1];
                                    readableUserBoard[i] = all.readableUserHand[which - 1];
                                    all.userHand[which - 1] = 0;
                                    all.readableUserHand[which - 1] = null;
                                    System.out.println("Your total -> " + userTotal);
                                    computerCall();
                                    break;
                                }
                            }
                    }
                }
            }
        }
        else if(userTotal==20){
            System.out.println("Wait for the computer's move.");
            computerCall();
        }
        else{
            System.out.println("YOU LOSE!");
            restart(0, 1);
        }
        i++;
        computerCall();
    }


    public static void computerCall(){
        if(computerTotal<20){
            computerTotal+=all.currentGameDeck[i+1];
            computerBoard[i]=all.currentGameDeck[i+1];
            readableComputerBoard[i]=all.currentColorDeck[i+1]+computerBoard[i]+RESET;
            if(computerTotal==20 && userTotal!=20){
                System.out.println("YOU LOSE!!");
                restart(0,1);
            }
            else if(computerTotal==20){
                System.out.println("DRAW!! No one wins!");
                restart(0,0);
            }
            else if(computerTotal>20){
                if(userTotal<20) {
                    System.out.println("Computer total ->"+computerTotal);
                    System.out.println("YOU WIN!!!");
                    restart(1,0);
                }
            }
        }
        else if(hold==false){
            switches();
        }
    }

    public static void hold(){
        System.out.println("Your total -> " +userTotal+"\nComputer's total -> " +computerTotal);
        computerCall();
        if(userTotal>computerTotal){
            System.out.println("YOU WIN!!");
            restart(1,1);
        }
        else{
            System.out.println("YOU LOSE!!");
            restart(0,1);
        }

    }
    public static int computerWinCounter;
    public static int userWinCounter;
    public static void restart(int u, int c){
        userWinCounter += u;
        computerWinCounter += c;
        System.out.println("User: "+u+"//"+"Computer: "+c);
        if(u==3){
            System.out.println("WINNER IS YOU!!!!!");
        }
        else if(c==3){
            System.out.println("YOU LOSE AGAINST THE EASY MODE COMPUTER XD!!!");
        }

        userWinCounter = 0;
        computerWinCounter = 0;

        userBoard = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        readableUserBoard = new String[]{null, null, null, null, null, null, null, null, null};

        computerBoard = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        readableComputerBoard = new String[]{null, null, null, null, null, null, null, null, null};

        userTotal = 0;
        computerTotal = 0;

        gameIsRunning = true;
        hold = true;

        all = new playerHand();

        i = 0;
    }
}








