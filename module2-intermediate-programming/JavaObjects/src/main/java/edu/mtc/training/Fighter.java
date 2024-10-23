package edu.mtc.training;

public class Fighter extends Airplane{

  public Fighter(int speed, String name) {
    super(speed, name);
  }

  public void fire() {
    System.out.println(this.name + " fires a missile!!!");
  }

  //another way of overloading the method or polymorphism
  //this is the same method named fire, one with a parameter & one without
  public void fire(String target){
    System.out.println((this.name + " fires a missile at " + target + "!!!"));
  }

}
