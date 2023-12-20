public class BlueJack {
    public static void main (String [] args){
        playerDeck players = new playerDeck();

        for(int i=0; i<players.readableComputerDeck.length; i++){
            System.out.println(players.readableComputerDeck[i]);
        }
        System.out.println("-----");
        for(int i=0; i<players.readableComputerDeck.length; i++){
            System.out.println(players.computerDeck[i]);
        }
        System.out.println("/////////////////////////////");
        for(int i=0; i<players.readableUserDeck.length; i++){
            System.out.println(players.readableUserDeck[i]);
        }
        System.out.println("-----");
        for(int i=0; i<players.readableUserDeck.length; i++){
            System.out.println(players.userDeck[i]);
        }

    }
}
