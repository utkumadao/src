import java.util.Random;
public class playerDeck {

    gameDeck card = new gameDeck();

    public int [] userDeck = new int [10];
    public String [] readableUserDeck = new String [10];

    public int [] computerDeck = new int [10];
    public String [] readableComputerDeck = new String [10];


    public playerDeck() {
        Random r = new Random();

        //FOR USER FOR USER FOR USER FOR USER
        int bottom = card.gameDeck.length - 1;//user taking from bottom of the deck
        for (int i = 0; i < 5; i++) {//for first 5 card
            userDeck[i] = card.gameDeck[bottom];
            readableUserDeck[i] = card.colors[bottom]+userDeck[i]+card.RESET;
            bottom--;

        }

        int nextuser = 5;
        while (nextuser != 8) {
            int rValue = r.nextInt(6) + 1;
            int rSign = r.nextInt(2);
            int rColor = r.nextInt(4);
            userDeck[nextuser] = rValue * card.sign[rSign];
            readableUserDeck[nextuser] = card.paint[rColor]+userDeck[nextuser]+card.RESET;
            nextuser++;
        }

        while (nextuser != 10){
            int chance = r.nextInt(5);
            if(chance<4) { //%80
                int rValue = r.nextInt(6) + 1;
                int rSign = r.nextInt(2);
                int rColor = r.nextInt(4);
                userDeck[nextuser] = rValue * card.sign[rSign];
                readableUserDeck[nextuser] = card.paint[rColor]+userDeck[nextuser]+card.RESET;
                nextuser++;
            }
            else{ //%20
                int specialChance = r.nextInt(2);
                userDeck[nextuser] = card.eqForSpecial[specialChance];
                readableUserDeck[nextuser] = card.special[specialChance];
                nextuser++;
            }
        }


        //FOR COMPUTER FOR COMPUTER FOR COMPUTER
        int top = 0;//computer taking from top of the deck
        for (int i = 0; i < 5; i++) {//for first 5 card
            computerDeck[i] = card.gameDeck[top];
            readableComputerDeck[i] = card.colors[top]+computerDeck[i]+card.RESET;
            top++;
        }

        int nextcomp = 5;
        while (nextcomp != 8) {
            int rValue = r.nextInt(6) + 1;
            int rSign = r.nextInt(2);
            int rColor = r.nextInt(4);
            computerDeck[nextcomp] = rValue * card.sign[rSign];
            readableComputerDeck[nextcomp] = card.paint[rColor]+computerDeck[nextcomp]+card.RESET;
            nextcomp++;
        }

        while (nextcomp != 10){
            int chance = r.nextInt(5);
            if(chance<4) { //%80
                int rValue = r.nextInt(6) + 1;
                int rSign = r.nextInt(2);
                int rColor = r.nextInt(4);
                computerDeck[nextcomp] = rValue * card.sign[rSign];
                readableComputerDeck[nextcomp] = card.paint[rColor]+computerDeck[nextcomp]+card.RESET;
                nextcomp++;
            }
            else{ //%20
                int specialChance = r.nextInt(2);
                computerDeck[nextcomp] = card.eqForSpecial[specialChance];
                readableComputerDeck[nextcomp] = card.special[specialChance];
                nextcomp++;
            }
        }
    }
}
