package edu.mtc.training;

//defined our class which is the blueprint of the object
//this is the blueprint of the object

//Best Practices structure
//fields & properties are listed at the top
//constructors next
//any behavioral methods

public class Vehicle implements Throttle {

  //research access modifiers
  //this is package protected (which is default) and it is not quite private or public
  int speed = 10;
  public String name = "Test"; //access modifier private makes it only accessible to the class

  //Constructors are functions that are called automatically when an object is created
  //Constructors (allows us to set them from the main method)
  //always define a default constructor when you have 1 or more so you can pass in 0 parameters
  //if you don't define it and you define at least 1 constructor, you lose access to your default constructor
  Vehicle(){ //default constructor

  }
  Vehicle(int speed, String name){
    this.speed = speed;
    this.name  = name;
  }
  //the following is called overloading your constructors and is a form of polymorphism
  Vehicle(int speed){
    this.speed = speed;
  }

  Vehicle(String name){
    this.name = name;
  }

  //Behavioral Method
  //don't have to pass in the speed parameter and can use the this keyword
  void move(){
    System.out.println(name + " moves " + this.speed + " mph");
  }

  /* Inheritance
  when one object inherits all the properties and methods of another object
  when one class is based off of another class & takes the original classes functionality & data types
  this new object extends the functionality of the original object
  *  */

  //Polymorphism - overload vs override
  //overriding a method doesn't allow the super class to execute the method when called.

  //final keyword - a modifier that prevents a method or field or class from changing
  //it cannot be extended, overridden, or the value changed & value is constant

}
