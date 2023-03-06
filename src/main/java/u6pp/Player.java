package u6pp;

import java.util.ArrayList;

public class Player {
    String name;
    ArrayList <Card> hand = new ArrayList<Card>();
    
    
    public Player() {
        name = "Don Juan";
        
    }

    public Player(String nombre){
        name = nombre;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }
    
}
