package Homework1.Part3;

 /* Card class that implements a Comparable interface to compare the values I specifically set for each of the suits and then ranks */
public class Card implements Comparable<Card> {
	
	// variables
    private String card;
    private int suit;
    private int rank;
    private int overallRank;

    /* Constructor that accepts a String card variable */
    public Card(String card) {
        this.card = card;

        // Assign suit values as ints
        // charAt(0) used for the first value which is the suit 
        switch (card.charAt(0)) {
            case 'S':
                suit = 0;
                break;
            case 'H':
                suit = 13;
                break;
            case 'D':
                suit = 26;
                break;
            case 'C':
                suit = 39;
                break;
            default:
                break;
        }
           
        // Assign rank values as ints
        // charAt(1) used for the second value which is the rank for values suits that have 10 in it, e.x: S10, H10, D10, C10
        if (card.length() == 3) { 
            rank = 5;
		} 
			switch (card.charAt(1)) {
			case 'A':
				rank = 1;
				break;
			case 'K':
				rank = 2;
				break;
			case 'Q':
				rank = 3;
				break;
			case 'J':
				rank = 4;
				break;
			case '9':
				rank = 6;
				break;
			case '8':
				rank = 7;
				break;
			case '7':
				rank = 8;
				break;
			case '6':
				rank = 9;
				break;
			case '5':
				rank = 10;
				break;
			case '4':
				rank = 11;
				break;
			case '3':
				rank = 12;
				break;
			case '2':
				rank = 13;
				break;
			default:
				break;
		}
        // set overall rank below by adding the both the suit and rank together
        overallRank = suit + rank;
    }

    /* compareTo method of the comparable interface that returns a integer used to sort the cards; accepts a parameter of the Card object type */
    public int compareTo(Card card) {
        if (overallRank - card.getOverallRank() < 0) { // if the overallRank - given OverallRank < 0 returns a -1, meaning that overallRank < card's overallRank
            return -1; // move down
        }
        if (overallRank - card.getOverallRank() > 0) { // if the overallRank - given OverallRank > 0 returns a 1, meaning that overallRank > card's overallRank
            return 1; // move up
        }
        return 0; // if equal, same spot
    }

    /* getter method for overallRank */
    public int getOverallRank() {
        return overallRank;
    }
    
    /* setter method for Card */
    public void setCard(String card) {
        this.card = card;
    }

    /* getter method for Card */
    public String getCard() {
        return card;
    }
    
    /* overridden toString method that returns a string description of each card */
    public String toString() {
        return card;
    }
}
