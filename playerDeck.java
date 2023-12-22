import java.util.Random;
public class playerDeck {

    gameDeck game = new gameDeck();

    public int[] userDeck = new int[10];
    public String[] readableUserDeck = new String[10];

    public int[] computerDeck = new int[10];
    public String[] readableComputerDeck = new String[10];

    public int [] currentGameDeck = new int[30];//total 10 cards given to players
    public String [] currentColorDeck = new String[30];

    public playerDeck() {
        Random r = new Random();

        //FOR USER FOR USER FOR USER FOR USER
        int bottom = game.gameDeck.length - 1;//user taking from bottom of the deck
        for (int i = 0; i < 5; i++) {//for first 5 card
            userDeck[i] = game.gameDeck[bottom];
            readableUserDeck[i] = game.colors[bottom] + userDeck[i] + game.RESET;
            bottom--;

        }

        int nextuser = 5;
        while (nextuser != 8) {
            int rValue = r.nextInt(6) + 1;
            int rSign = r.nextInt(2);
            int rColor = r.nextInt(4);
            userDeck[nextuser] = rValue * game.sign[rSign];
            readableUserDeck[nextuser] = game.paint[rColor] + userDeck[nextuser] + game.RESET;
            nextuser++;
        }

        while (nextuser != 10) {
            int chance = r.nextInt(5);
            if (chance < 4) { //%80
                int rValue = r.nextInt(6) + 1;
                int rSign = r.nextInt(2);
                int rColor = r.nextInt(4);
                userDeck[nextuser] = rValue * game.sign[rSign];
                readableUserDeck[nextuser] = game.paint[rColor] + userDeck[nextuser] + game.RESET;
                nextuser++;
            }
            else { //%20
                int specialChance = r.nextInt(2);
                userDeck[nextuser] = game.eqForSpecial[specialChance];
                readableUserDeck[nextuser] = game.special[specialChance];
                nextuser++;
            }
        }


        //FOR COMPUTER FOR COMPUTER FOR COMPUTER
        int top = 0;//computer taking from top of the deck
        for (int i = 0; i < 5; i++) {//for first 5 card
            computerDeck[i] = game.gameDeck[top];
            readableComputerDeck[i] = game.colors[top] + computerDeck[i] + game.RESET;
            top++;
        }

        int nextcomp = 5;  //next 6,7,8. cards
        while (nextcomp != 8) {
            int rValue = r.nextInt(6) + 1;
            int rSign = r.nextInt(2);
            int rColor = r.nextInt(4);
            computerDeck[nextcomp] = rValue * game.sign[rSign];
            readableComputerDeck[nextcomp] = game.paint[rColor] + computerDeck[nextcomp] + game.RESET;
            nextcomp++;
        }

        while (nextcomp != 10) {  //9. and 10. cards
            int chance = r.nextInt(5);
            if (chance < 4) { //%80
                int rValue = r.nextInt(6) + 1;
                int rSign = r.nextInt(2);
                int rColor = r.nextInt(4);
                computerDeck[nextcomp] = rValue * game.sign[rSign];
                readableComputerDeck[nextcomp] = game.paint[rColor] + computerDeck[nextcomp] + game.RESET;
                nextcomp++;
            }
            else { //%20
                int specialChance = r.nextInt(2);
                computerDeck[nextcomp] = game.eqForSpecial[specialChance];
                readableComputerDeck[nextcomp] = game.special[specialChance];
                nextcomp++;
            }
        }
        for(int i=0; i<currentGameDeck.length; i++){
            currentGameDeck[i]=game.gameDeck[i+5];
            currentColorDeck[i]=game.colors[i+5];
        }
    }
}