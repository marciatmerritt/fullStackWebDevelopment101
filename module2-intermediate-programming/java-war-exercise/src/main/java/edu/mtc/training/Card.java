package edu.mtc.training;

public class Card {
  private int rank;
  private int suit;
  public boolean isFaceUp;

  private static final String[] CARDRANKS = {
      null, "A", "2", "3", "4",
      "5", "6", "7", "8", "9",
      "10", "J", "Q", "K"
  };

  private static final String[] CARDSUITS = {
      "Hearts", "Spades", "Clubs", "Diamonds"
  };

  Card() {}

  public Card(int suit, int rank) {

    if (rank < 1 || rank > 13) {
      throw new IllegalArgumentException("Invalid rank: " + rank);
    }
    if (suit < 0 || suit > 3) {
      throw new IllegalArgumentException("Invalid suit: " + suit);
    }

    this.suit = suit;
    this.rank = rank;
    isFaceUp = false;
  }
  public int getRank() {
    return this.rank;
  }
  public int getSuit() {
    return this.suit;
  }
  public void flipCard() {
    isFaceUp = !isFaceUp;
  }

  public String toString() {
    String str = "";

    if (isFaceUp) {
      str += CARDRANKS[rank] + " of " + CARDSUITS[suit];
    }
    return str;
  }

}