package u6pp;

import java.util.ArrayList;
import java.util.Random;

public class CardStack {
    ArrayList <Card> stack = new ArrayList<Card>();
    Random random = new Random();
    
    public CardStack() {
        //ArrayList <Card> stack = new ArrayList<Card>();
    }
    

    public void shuffle(){
        for (int i = stack.size()-1; i > 0; i--){
            int j = random.nextInt(i+1);
            Card k = stack.get(j);
            stack.set(j, stack.get(j));
            stack.set(i,k);
        }
    }

    //merges two different decks
    public void addAll(CardStack deck){
        if(this == deck){
            return;
        }
        if(deck.getSize() > 0){
                for(int i = 0; i <= deck.getSize(); i++){
                    this.stack.add(i, deck.pop());
                }
            }
        
        }

    //puts a card on top of deck. top of deck is index 0
    public void push(Card card){
        stack.add(0, card);
    }
    
    //removes card from top of deck at index 0
    public Card pop(){
        Card oops = stack.get(0);
        stack.remove(0);
        return oops;
    }
    
    //the getter
    public Card peek(){
        if(getSize() == 0){
            return null;
        } else{
            return stack.get(0);
        }
    }

    //size of deck
    public int getSize(){
        return stack.size();
    }

    //checks if the stack is empty 
    public boolean isEmpty(){
        if(getSize() <= 0){
            return true;
        }
        return false;
    }
    
    //empties the card stack
    public void clear(){
        stack.removeAll(stack);
    }

    public static CardStack createUnoDeck() {
        CardStack stack = new CardStack();
        for (String color : Card.COLORS) {
            if (color.equalsIgnoreCase(Card.WILD)) {
                continue;
            }
    
            for (String value : Card.VALUES) {
                if (value.equals(Card.WILD) || value.equals(Card.WILD_DRAW_4)) {
                    continue;
                }
                stack.push(new Card(color, value));
                if (!value.equalsIgnoreCase(Card.ZERO)) {
                    stack.push(new Card(color, value));
                }
            }
        }
    
        for (int i = 0; i < 4; i++) {
            stack.push(new Card(Card.WILD, Card.WILD));
            stack.push(new Card(Card.WILD, Card.WILD_DRAW_4));
        }
    
        return stack;
    }

    //test method that prints values in stack
    // private void printStack(){
    //     for (Card card : stack) {
    //         System.out.println(card.color + " " + card.value);
    //     }
    // }

}
