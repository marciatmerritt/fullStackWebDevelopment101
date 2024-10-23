package edu.mtc.training;

public class Airplane extends Vehicle{ //extends allows inheritance Vehicle is the parent class

  //doesn't need a default constructor because it is inherited from the parent
  Airplane(int speed, String name){
    //super keyword calls the constructor from the parent class
    super(speed, name);
  }

  public void takeOff(){  //method for takeoff void = doesn't return anything
    System.out.println(this.name + " takes off");
  }

  @Override
  public void move(){
    System.out.println(this.name + " flies " + this.speed + "mph!");
    super.move(); //this still accesses the parent as well
  }

}
