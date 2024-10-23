package com.catalyte.training.monkeytesting;

/**                M O N K E Y  T R O U B L E                                         ******
 **   We have two monkeys, a and b, and the parameters aSmile and bSmile              ******
 **   indicate if each is smiling. We are in trouble if they are both smiling or if   ******
 **   neither of them is smiling. Return true if we are in trouble.                   ******
 **                                                                                   ******
 **   Possible input values and the expected return are as follows:                   ******
 **                                             MonkeyTrouble(true, true)   → true    ******
 **                                             MonkeyTrouble(false, false) → true    ******
 **                                             MonkeyTrouble(true, false)  → false   ******
 **                                             MonkeyTrouble(false, true)  → false   ******/
public class MonkeyTrouble {

  public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {

    return (aSmile && bSmile) || (!aSmile && !bSmile);
  }

  //Stretch Requirements
  public boolean monkeyTroubleThree(boolean aSmile, boolean bSmile, boolean cSmile){

    return (aSmile && bSmile && cSmile) || (!aSmile && !bSmile && !cSmile);
  }
}
