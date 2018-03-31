package Homework1.Part3;
/*  CSE 214 Fall 2017, Professor Shebuti Rayana
 *  Ivan Tinov
 *  ID# 110255332
 *  Homework 1
 */

import java.util.Arrays;

/* Player class that contains the setCards method and sortCards method */
public class Player {

	// variables  
    private int id; // player id
    private Card[] cards = new Card[13]; // creates a new array of 13 cards for player 1

    /* Constructor that accepts an id parameter for player 1*/
    public Player(int id) {
        this.id = id;
    }

    /* setter method for the id */
    public void setId(int id) {
        this.id = id;
    }

    /* getter method for the id */
    public int getId() {
        return id;
    }

    /* setter method for the cards that accepts a Card[] parameter */
    public void setCards(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            this.cards[i] = cards[i];
        }
    }

    /* getter method for cards that returns the cards */
    public Card[] getCards() {
        return cards;
    }

    /* sortCards method that uses Arrays.sort to sort the cards using the compareTo method in the Card class */
    public void sortCards(Card[] cards) {
        Arrays.sort(cards);
    }

    /* printCards method to print the value of each card */
    public void printCards() {
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + " ");
        }

    }

    /* toString method that prints cards */
    public String toString() {
        return getCards() + " ";
    }

}
