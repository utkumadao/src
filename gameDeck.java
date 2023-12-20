import java.util.Random;
public class gameDeck {
    Random r = new Random();
    public int [] gameDeck = new int [40];

    //values of cards
    public int [] value = {1,2,3,4,5,6,7,8,9,10};

    //colors of cards
    public String RESET = "\u001B[0m";
    public String RED = "\u001B[31m";
    public String GREEN = "\u001B[32m";
    public String YELLOW = "\u001B[33m";
    public String BLUE = "\u001B[34m";
    public String [] paint = {RED, GREEN, YELLOW, BLUE};
    public String [] colors = new String [40];

    //signs
    public int [] sign = {1, -1};

    //special cards
    public int [] eqForSpecial = {100,101}; //100 for x2, 101 for +/-
    public String [] special = {"x2", "+/-"};

    public gameDeck() {
        for (int i = 0; i < 10; i++) {//parts of cards (as array)
            gameDeck[i] = value[i];
            gameDeck[10 + i] = value[i];
            gameDeck[20 + i] = value[i];
            gameDeck[30 + i] = value[i];

            colors[i] = RED;
            colors[i + 10] = GREEN;
            colors[i + 20] = YELLOW;
            colors[i + 30] = BLUE;
            //there will be an if condition. if(colors[i].equals(...)) print(...+String.valueOf(gameDeck[i])+RESET)
        }
        //shuffle
        int keeper1;
        String keeper2;
        for (int i = gameDeck.length - 1; i>-1 ; i--) {
            int a = r.nextInt(gameDeck.length);
            keeper1 = gameDeck[i];
            gameDeck[i] = gameDeck[a];
            gameDeck[a] = keeper1;
            keeper2 = colors[i];
            colors[i] = colors[a];
            colors[a] = keeper2;
        }
    }

}
