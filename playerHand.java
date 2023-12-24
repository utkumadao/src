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


        int keeper1;
        String keeper2;
        for (int i = player.userDeck.length - 1; i > -1; i--) {
            int a = r.nextInt(player.userDeck.length);
            keeper1 = player.userDeck[i];
            player.userDeck[i] = player.userDeck[a];
            player.userDeck[a] = keeper1;
            keeper2 = player.readableUserDeck[i];
            player.readableUserDeck[i] = player.readableUserDeck[a];
            player.readableUserDeck[a] = keeper2;
        }
        for(int i=0; i<userHand.length; i++){
            userHand[i] = player.userDeck[i];
            readableUserHand[i] = player.readableUserDeck[i];
        }

        int keeper3;
        String keeper4;
        for (int i = player.computerDeck.length - 1; i > -1; i--) {
            int a = r.nextInt(player.computerDeck.length);
            keeper3 = player.computerDeck[i];
            player.computerDeck[i] = player.computerDeck[a];
            player.computerDeck[a] = keeper3;
            keeper4 = player.readableComputerDeck[i];
            player.readableComputerDeck[i] = player.readableComputerDeck[a];
            player.readableComputerDeck[a] = keeper4;
        }
        for(int i=0; i<computerHand.length; i++){
            computerHand[i] = player.computerDeck[i];
            readableComputerHand[i] = player.readableComputerDeck[i];
        }

        for(int i=0; i<currentGameDeck.length; i++){
            currentGameDeck[i]=player.currentGameDeck[i];
            currentColorDeck[i]=player.currentColorDeck[i];
        }
    }
}
