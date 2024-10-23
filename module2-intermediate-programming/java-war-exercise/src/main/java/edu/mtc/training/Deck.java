package edu.mtc.training;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  public ArrayList < Card > deck;

  public Deck() {
    deck = new ArrayList < > ();
    for (int i = 0; i < 4; i++) {
      for (int j = 1; j <= 13; j++) {
        deck.add(new Card(i, j));
      }
    }
    Collections.shuffle(deck);
  }

  public boolean isEmpty() {
    return deck.isEmpty();
  }

  public int countCards() {
    return deck.size();
  }

  //deal 1 card at a time to the hand
  public void dealCard(Hand otherHand) {
    otherHand.add(deck.remove(0));
  }
}