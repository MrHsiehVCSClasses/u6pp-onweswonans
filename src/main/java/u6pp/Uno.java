package u6pp;
import java.util.ArrayList;

public class Uno {
    ArrayList<Player> players = new ArrayList<>();
    CardStack deck = new CardStack();
    CardStack discard = new CardStack();
    int turn;
    boolean reversed;

    public Uno(ArrayList<Player> player, CardStack deck, CardStack discard, int curturn, boolean reversed) {
        this.players = player;
        this.deck = deck;
        this.discard = discard;
        this.turn = curturn;
        this.reversed = reversed;

    }

    public Uno(int numplayers){
        deck = CardStack.createUnoDeck();
        deck.shuffle();
        discard.push(deck.pop());
        for (int i = 0; i < numplayers; i++){
            players.add( new Player());
        }
        for(int i = 0; i < players.size(); i++){
            System.out.println(deck.getSize());
            players.get(i).getHand().add(deck.pop());
            players.get(i).getHand().add(deck.pop());
            players.get(i).getHand().add(deck.pop());
            players.get(i).getHand().add(deck.pop());
            players.get(i).getHand().add(deck.pop());
            players.get(i).getHand().add(deck.pop());
            players.get(i).getHand().add(deck.pop());
            System.out.println(deck.getSize());

        }
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public Player getCurrentPlayer(){
        return players.get(turn);
    }
    
    public Player getNextPlayer(){
        if(reversed == false){
            if(turn == players.size()-1){
                turn = 0;
                return players.get(0);
            }
            return players.get(turn +1);
        }
        if(turn == 0){
            turn = players.size()-1;
            return players.get(players.size()-1);
        }
        return players.get(turn -1);
    }

    public Card getTopDiscard(){
        return discard.peek();
    }

    public Player getWinner(){
        for (Player player : players) {
            if(player.getHand().size() == 0){
                return player;
            }
        }
        return  null;
    }

    public boolean playCard(Card card, String string){
        //checks if hand is empty and adds 1 card
        if(card == null){
            shuffleIfEmpty();
            getCurrentPlayer().getHand().add(deck.pop());
            shuffleIfEmpty();
            cheekyBreeky(false);
        }
        //changes card color
        if(card.trySetColor(string) == true){
            System.out.println("good job " + card.toString());
        }
        // checks if cards are in hand
        for (Card crd : getCurrentPlayer().getHand()) {
            if(crd == card){
                if(card.canPlayOn(discard.peek()) == true){
                    System.out.println("can be played");
                    if(card.getValue().equalsIgnoreCase("reverse")){
                        if(reversed == true){
                            System.out.println("count up");
                            reversed = false;
                        } else{
                            System.out.println("count down");
                            reversed = true;
                        }
                    }
                    discard.push(card);
                    getCurrentPlayer().getHand().remove(crd);
                    if(card.getValue().equalsIgnoreCase("SKIP") || card.getValue().equalsIgnoreCase("Draw_2") || card.getValue().equalsIgnoreCase("Wild_Draw_4")){
                        System.out.println("cheekybreakytrue");
                        if(card.getValue().equalsIgnoreCase("Draw_2")){
                            System.out.println("it drawtwo");
                            cheekyBreeky(true);
                            givesCards(2);
                        }else if (card.getValue().equalsIgnoreCase("Wild_Draw_4")){
                            cheekyBreeky(true);
                            givesCards(4);
                            System.out.println("it draw 4");
                        } else{
                            cheekyBreeky(true);
                        }
                        System.out.println(getCurrentPlayer().getName());
                    }else{
                        System.out.println("checlybrelkyfalse");
                        cheekyBreeky(false);
                    }
                    return true;
                }
                return false;
            }
        }
        System.out.println("gay");
        return false;
    }
    
    
    private void shuffleIfEmpty(){
        if(deck.isEmpty() == true){
            deck.addAll(discard);
            deck.shuffle();
            discard.push(deck.pop());
        } 
    }

    //checks skip r not and if reverse or not
    private void cheekyBreeky(boolean skiprnot){
        if(reversed == false){
            if(skiprnot == true){
                System.out.println("130"+getCurrentPlayer().getName());
                if(turn == players.size()-1){
                    System.out.println("124");
                    turn = 1;

                } else if (turn == players.size()-2){
                    System.out.println("127");
                    turn = 0;

                } else{
                    System.out.println("137");
                    turn ++;
                    turn ++;

                }
            } else if(turn == players.size()-1){
                turn = 0;
            } else{
                turn++;
            }
        } else{
            if(skiprnot == true){
                if(turn == 0){
                    turn = players.size()-2;

                } else if (turn == 1){
                    turn = players.size()-1;

                } else{
                    turn --;
                    turn --;


                }
            } else if(turn == 0){
                turn = players.size()-1;
            }
            else{
                turn --;
            }
        }
    }

    private void givesCards(int cards){
        Player doop;
        if(reversed == true){
            doop =players.get(turn + 1);
        } else{
            doop = players.get(turn -1);
        }
        for(int i = 0; i < cards; i++){
            shuffleIfEmpty();
            doop.getHand().add(deck.pop());
            shuffleIfEmpty();
        }
    }
}


