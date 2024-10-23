package org.example;

public class Card {

  //Private Fields
  private Suit suit;
  private Rank rank;
  private boolean isFaceUp;

  //Constructor Method
  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
    isFaceUp = true;
  }
  //Public Methods
  public String getSuit() {
    return suit.printSuit();
  }
  public int getRank(){
    return rank.getRank();
  }

  public void flipCard(){
    isFaceUp = !isFaceUp;
  }
//  @Override toString method
  public String toString() {
    String str = "";
    if (isFaceUp) {
      str += rank.getRank() + " of " + suit.printSuit();
    }
    return str;
  }




}
