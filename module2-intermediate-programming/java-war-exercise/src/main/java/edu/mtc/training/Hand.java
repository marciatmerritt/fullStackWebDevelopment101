package edu.mtc.training;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {

  private ArrayList < Card > cards;

  //Constructor
  public Hand() {
    cards = new ArrayList < Card > ();
  }

  //Public methods
  public boolean isEmpty() {
    return cards.isEmpty();
  }
  public void clear() {
    cards.clear();
  }
  public void add(Card card) {
    cards.add(card);
  }

  //put all cards from input hand to the other hand and then clear input hand
  public void giveAll(Hand otherHand) {
    for (Card c: cards) {
      otherHand.add(c);
    }
    clear();
  }

  // All cards are flipped face down
  public void flipAllCardsFaceDown() {
    for (Card c: cards) {
      if (c.isFaceUp) {
        c.flipCard();
      }
    }
  }

  // Removes/returns card from top of array
  public Card playCard() {
    return cards.remove(0);
  }
  public int countCards() {
    return cards.size();
  }

  //if any cards are face up, turn them face down and then shuffle the hand
  public void shuffleHand() {
    flipAllCardsFaceDown();
    Collections.shuffle(cards);
  }
  public String showHand() {

    String str = "";
    for (Card c: cards) {
      str += c.toString() + "\n";
    }
    return str;
  }

}