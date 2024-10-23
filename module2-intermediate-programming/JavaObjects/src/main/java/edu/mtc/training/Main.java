package edu.mtc.training;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

  public static void main(String[] args) { // main method - entry point into program

    //strongly type variables
    //if 0 constructors in your class, you don't have to have a default parameter in your call
    //once you define a constructor in your class, you have to include a default constructor
    //  Vehicle whip = new Vehicle(50, "Whip");  //instantiated vehicle object
    //  whip.speed = 100;
    //  whip.move();

      Airplane whip2 = new Airplane(150, "Whip2");
      whip2.move();
      whip2.takeOff();

      Fighter fighter = new Fighter(500, "Thunder");
      fighter.move();
      fighter.takeOff();
      fighter.fire();
      fighter.fire("Whip2");

  }
}