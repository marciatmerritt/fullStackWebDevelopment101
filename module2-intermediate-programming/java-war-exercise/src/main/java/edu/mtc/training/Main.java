package edu.mtc.training;

/**
 * I Declare War card game
 * After run is clicked: A new shuffled deck is created and evenly distributed face down between two players.
 * Each player puts down one card. Whichever player's card is highest in rank gets both cards added into their hand.
 * If the players put down cards with the same rank, war begins (I Declare War) and each player puts 3 cards face down followed by a fourth
 * that is face up. Whoever wins gets all cards put on the table. Repeat until one player has all the cards.
 */
public class Main {
    public static void main(String[] args) {

        Deck deck    = new Deck(); //create new shuffled deck

        Hand player1 = new Hand();
        Hand player2 = new Hand();
        Hand table   = new Hand();

        //deal cards evenly to player 1 & player 2
        do {
            deck.dealCard(player1);
            deck.dealCard(player2);
        }
        while (!deck.isEmpty());

        //shuffle player hands
        player1.shuffleHand();
        player2.shuffleHand();

        boolean gameIsRunning = true;
        int round = 0;
        Card p1, p2;

        while (gameIsRunning) {

            //players puts card on table face up
            p1 = player1.playCard();
            p1.flipCard();
            table.add(p1);

            p2 = player2.playCard();
            p2.flipCard();
            table.add(p2);

            System.out.println(" Round " + round++ + " of The War");
            System.out.println("Player 1: " + p1);
            System.out.println("Player 2: " + p2);

            if (p1.getRank() > p2.getRank()) {
                table.shuffleHand();
                table.giveAll(player1);
                System.out.println("Player One Wins the Round \n");
            } else if (p1.getRank() < p2.getRank()) {
                table.shuffleHand();
                table.giveAll(player2);
                System.out.println("Player Two Wins the Round \n");
            } else if (p1.getRank() == p2.getRank()) {
                makeWar(player1, player2, table);
            }

            if (player1.isEmpty()) {
                System.out.println("Player One has run out of cards. Player Two Wins the Game!");
                gameIsRunning = false;
            } else if (player2.isEmpty()) {
                System.out.println("Player Two has run out of cards. Player One Wins the Game!");
                gameIsRunning = false;
            }
        }
    }

    public static void makeWar(Hand player1, Hand player2, Hand table) {

        System.out.println("War Begins!");

        Card p1, p2;

        if (player1.countCards() < 4) {
            table.giveAll(player2);
            player1.giveAll(player2);
            return;
        }

        if (player2.countCards() < 4) {
            table.giveAll(player1);
            player2.giveAll(player1);
            return;
        }

        //players put 3 cards on the table face down
        for (int i = 0; i < 3; i++) {
            table.add(player1.playCard());
            table.add(player2.playCard());
        }

        //players put the 4th card on the table face up
        p1 = player1.playCard();
        p1.flipCard();
        table.add(p1);

        p2 = player2.playCard();
        p2.flipCard();
        table.add(p2);

        System.out.println("Player 1: " + p1);
        System.out.println("Player 2: " + p2);

        if (p1.getRank() > p2.getRank()) {
            table.shuffleHand();
            table.giveAll(player1);
            System.out.println("Player One Wins the War \n");
        } else if (p1.getRank() < p2.getRank()) {
            table.shuffleHand();
            table.giveAll(player2);
            System.out.println("Player Two Wins the War \n");
        } else if (p1.getRank() == p2.getRank()) {
            makeWar(player1, player2, table);
        }

    }

}