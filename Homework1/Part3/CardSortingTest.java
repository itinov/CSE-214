package Homework1.Part3;
/*  CSE 214 Fall 2017, Professor Shebuti Rayana
 *  Ivan Tinov
 *  ID# 110255332
 *  Homework 1
 */

/* Main Class for running the program */
public class CardSortingTest {

	/* Main Method */
    public static void main(String[] args) {

        String[] cardsForPlayer1 = {
            "S4", "D8", "C4", "D3", "D5", "DJ", "S3", "D4", "DA", "SJ", "D7", "H10", "D6"}; // set an array of cards for player1

        Player player = new Player(1); // call player constructor and set id = 1;

        for (int i = 0; i < cardsForPlayer1.length; i++) { // modified for-loop that goes over cardsForPlayer1 array
            player.getCards()[i] = new Card(cardsForPlayer1[i]); // set cardsForPlayer1 into a Card[] of the card class.
        }
        
        // printing out unsorted and sorted sequences.
        System.out.println("Original Sequence: ");
        player.printCards();
        // should print: S4 D8 C4 D3 D5 DJ S3 D4 DA SJ D7 H10 D6
        
        System.out.println("\nSorted Sequence: ");
        player.sortCards(player.getCards());
        player.printCards();
        // should print: SJ S4 S3 H10 DA DJ D8 D7 D6 D5 D4 D3 C4
        
    }
}
