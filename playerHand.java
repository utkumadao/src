import java.util.Random;
public class playerHand {
    playerDeck player = new playerDeck();

    public int [] userHand = new int[4];
    public String [] readableUserHand = new String[4];

    public int [] computerHand = new int[4];
    public String [] readableComputerHand = new String[4];

    public int [] currentGameDeck = new int[30];
    public String [] currentColorDeck = new String[30];

    public playerHand(){
        Random r = new Random();

        for(int i=0; i<userHand.length; i++){
            int rand = r.nextInt(player.userDeck.length);
            userHand[i] = player.userDeck[rand];
            readableUserHand[i] = player.readableUserDeck[rand];
        }

        for(int i=0; i<computerHand.length; i++){
            int rand = r.nextInt(player.computerDeck.length);
            computerHand[i] = player.computerDeck[rand];
            readableComputerHand[i] = player.readableComputerDeck[rand];
        }

        for(int i=0; i<currentGameDeck.length; i++){
            currentGameDeck[i]=player.currentGameDeck[i];
            currentColorDeck[i]=player.currentColorDeck[i];
        }
    }
}
