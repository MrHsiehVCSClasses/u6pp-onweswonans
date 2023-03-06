package u6pp;

public class Card {

    @Override
    public String toString() {
        return "Card [color=" + color + ", value=" + value + "]";
    }

    public static String RED = "RED";
    public static String GREEN = "GREEN";
    public static String BLUE = "BLUE";
    public static String YELLOW = "YELLOW";

    public static String ZERO = "0";
    public static String ONE = "1";
    public static String TWO = "2";
    public static String THREE = "3";
    public static String FOUR = "4";
    public static String FIVE = "5";
    public static String SIX = "6";
    public static String SEVEN = "7";
    public static String EIGHT = "8";
    public static String NINE = "9";

    public static String DRAW_2 = "DRAW_2";
    public static String REVERSE = "REVERSE";
    public static String SKIP = "SKIP";
    public static String WILD = "WILD";
    public static String WILD_DRAW_4 = "WILD_DRAW_4";

    // Wild color is the default color for wilds, before they are played. 
    public static String[] COLORS = {RED, GREEN, BLUE, YELLOW, WILD}; 
    public static String[] VALUES = {ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, 
        DRAW_2, REVERSE, SKIP, WILD, WILD_DRAW_4};
    
        String color;
        String value;
        
        public Card(String color, String value) {
            this.color = color;
            this.value = value;
        }

        public boolean trySetColor(String colour){
            for (String color : Card.COLORS){
                if(color.equalsIgnoreCase(colour)){
                    if(colour.equalsIgnoreCase("WILD") ||colour.equalsIgnoreCase("WILD_DRAW_4")){
                        return false;
                    }
                    if(getValue().equals("WILD") || getValue().equals("WILD_DRAW_4")){
                        this.color = colour;
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }

        public boolean canPlayOn(Card card){
            if(card == null){
                return false;
            }
            if(this.getColor().equalsIgnoreCase("WILD")){
                return true;
            }
            if(this.getColor().equals(card.getColor())){
                return true;
            } else if (this.getValue().equals(card.getValue())){
                return true;
            }
            return false;
        }

        public String getColor() {
            return color;
        }

        public String getValue() {
            return value;
        }

    // start you code here
    
}
