package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

  public static void main(String[] args) {

    Card c1, c2;

    c1 = new Card(Rank.FIVE, Suit.HEARTS);
    c2 = new Card(Rank.JACK, Suit.HEARTS);

    //flip cards
    c1.flipCard();
    c2.flipCard();

/*    if (c1.getRank() > c2.getRank()) {
      System.out.println(c1.toString() + " is greater than " + c2.toString());
    }
    else {
      System.out.println(c1.toString() + " is not greater than " + c2.toString());
    }
    System.out.println(c1.toString() + "\n" + c2.toString());*/

    //create a hand
    Hand


  }
}