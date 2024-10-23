package org.example;

import java.util.ArrayList;

public class Hand {
//this is the super class - basis of all hands including deck

  //Private fields
  private ArrayList<Card> cards;

  //Constructor
  public Hand() {
    cards = new ArrayList<Card>();
  }

  //Public Methods
  public void clear() {
    cards.clear();
  }
  public void add(Card card){
    cards.add(card);
  }
  public String showHand(){

    String str = "";
    for (Card c: cards) {
      str += c.toString() + "\n";
    }
    return str;
  }

  public boolean give(Card card, Hand otherHand){
    if (!cards.contains(card)) {
      return false;
    }
    else{
      cards.remove(card);
      otherHand.add(card);
      return true;
    }
  }

}
